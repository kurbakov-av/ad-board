package com.example.adboard.service;

import com.example.adboard.domain.chat.Chat;
import com.example.adboard.domain.chat.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    @Override
    public void create(Chat chat, String text) {

    }

    @Override
    public Page<ChatMessage> getPageMessages(Chat chat, Pageable pageable) {
        return null;
    }
}
