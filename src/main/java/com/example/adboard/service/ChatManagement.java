package com.example.adboard.service;

import com.example.adboard.domain.chat.Chat;
import com.example.adboard.domain.chat.ChatMessage;
import com.example.adboard.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChatManagement {

    Chat create(User addressed);

    void sendMessage(Long chatId, String text);

    Page<ChatMessage> receiveMessages(Long chatId, Pageable pageable);
}
