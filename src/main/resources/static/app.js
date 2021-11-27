var stompClient = null;
var audio = new Audio('shoryuken.mp3');
audio.loop = true;

audio.addEventListener('ended', function() {
	this.currentTime = 0;
	this.play();
}, false);


function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	}
	else {
		$("#conversation").hide();
	}
	$("#product-status").html("");
}

function connect() {
	var socket = new SockJS('/product-websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/pushinstock', function(message) {
			updatePage(JSON.parse(message.body));
		});
	});
}

function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

function updatePage(message) {

	$("#last-updated").text("last updated: " + new Date().toLocaleTimeString());
	$("#product-status").empty();
	$.each(message, function(index, product) {
		if (product.orderable == "Available") {
			$("#product-status").append("<tr class=\"orderable\"><td>" + new Date().toLocaleTimeString() + "</td><td>" + product.orderable + "</td><td>" + product.name + "</td><td><a href=" + product.addToCartUrl + ">" + product.addToCartUrl + "</a></td></tr>");
			openPurchasePage(product.addToCartUrl);
			disconnect();
			audio.play();
		} else {
			$("#product-status").append("<tr><td>" + product.orderable + "</td><td>" + "<tr><td>" + product.sku + "</td><td>" + product.name + "</td><td><a href=" + product.addToCartUrl + ">" + product.addToCartUrl + "</a></td></tr>");
		}

	});
}

function openPurchasePage(url) {
	var win = window.open(url, '_blank');
	if (win) {
		//Browser has allowed it to be opened
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() { connect(); });
	$("#disconnect").click(function() { disconnect(); });
});