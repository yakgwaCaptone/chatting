package com.capstone.chatting;


import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@Log4j2
public class ChatWebSocketHandler extends TextWebSocketHandler {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ChatWebSocketHandler(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 클라이언트로부터의 메시지 처리
        String receivedMessage = message.getPayload();
        // 로직 처리 및 클라이언트에게 메시지 전송
        String responseMessage = "서버에서 보낸 메시지: " + receivedMessage;
        session.sendMessage(new TextMessage(responseMessage));

        rabbitTemplate.convertAndSend("topic.exchange", "sample.realcold.#", receivedMessage);

    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session)throws Exception{

        System.out.println("클라이언트 접속"+ session);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        System.out.println(session + "클라이언트 접속 해제");

    }


}
