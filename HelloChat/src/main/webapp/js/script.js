/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

		var webSocket = new WebSocket("ws://localhost:8080/HelloChat/form");
		webSocket.onmessage = function processMessage(formMessage) {
			var json = JSON.parse(formMessage.data);
			document.getElementById('messages').value += json.received +':: ' + json.sender + ':' + json.message + '\n';
	        }
		
		function send() {
			var message = document.getElementById('message');
			webSocket.send(JSON.stringify({'message' : message.value, 'received' : null, 'sender' : 'Server'}));
			message.value = "";
		}
		
		window.onbeforeunload = function() {
			webSocket.onclose = function() {
				webSocket.close();
			}
		};
		
		
/*	var wsocket;
	var serviceLocation = "ws://0.0.0.0:8080/HelloChat/form/";
	var $nickName;
	var $message;
	var $chatWindow;
	var room = '';
 
	function onMessageReceived(evt) {
		//var msg = eval('(' + evt.data + ')');
		var msg = JSON.parse(evt.data); // native API
		var $messageLine = $('<tr><td class="received">' + msg.received
				+ '</td><td class="user label label-info">' + msg.sender
				+ '</td><td class="message badge">' + msg.message
				+ '</td></tr>');
		$chatWindow.append($messageLine);
	}
	function sendMessage() {
		var msg = '{"message":"' + $message.val() + '", "sender":"'
				+ $nickName.val() + '", "received":""}';
		wsocket.send(msg);
		$message.val('').focus();
	}
 
	function connectToChatserver() {
		room = $('#chatroom option:selected').val();
		wsocket = new WebSocket(serviceLocation + room);
		wsocket.onmessage = onMessageReceived;
	}
 
	function leaveRoom() {
		wsocket.close();
		$chatWindow.empty();
		$('.chat-wrapper').hide();
		$('.chat-signin').show();
		$nickName.focus();
	}
 
	$(document).ready(function() {
		$nickName = $('#nickname');
		$message = $('#message');
		$chatWindow = $('#response');
		$('.chat-wrapper').hide();
		$nickName.focus();
 
		$('#enterRoom').click(function(evt) {
			evt.preventDefault();
			connectToChatserver();
			$('.chat-wrapper h2').text('Chat # '+$nickName.val() + "@" + room);
			$('.chat-signin').hide();
			$('.chat-wrapper').show();
			$message.focus();
		});
		$('#do-chat').submit(function(evt) {
			evt.preventDefault();
			sendMessage()
		});
 
		$('#leave-room').click(function(){
			leaveRoom();
		});
	});
	
		<script type="text/javascript">
		var webSocket = new WebSocket("ws://localhost:8080/HelloChat/form");
		webSocket.onmessage = function processMessage(formMessage) {
			var json = JSON.parse(formMessage.data);
			document.getElementById('messages').value += json.message + '\n';
	        }
		
		function send() {
			var message = document.getElementById('message');
			webSocket.send(JSON.stringify({'message' : message.value, 'received' : null, 'sender' : 'Server'}));
			message.value = "";
		}
		
		window.onbeforeunload = function() {
			webSocket.onclose = function() {
				webSocket.close();
			}
		};
	</script>
	*/
