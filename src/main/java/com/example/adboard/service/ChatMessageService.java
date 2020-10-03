package com.example.adboard.service;

import com.example.adboard.domain.chat.Chat;
import com.example.adboard.domain.chat.ChatMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChatMessageService {

    void create(Chat chat, String text);

    Page<ChatMessage> getPageMessages(Chat chat, Pageable pageable);
}
