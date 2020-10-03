package com.example.adboard.service;

import com.example.adboard.domain.chat.Chat;
import com.example.adboard.domain.chat.ChatMessage;
import com.example.adboard.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatManagementImpl implements ChatManagement {

    @Override
    public Chat create(User addressed) {
        return null;
    }

    @Override
    public void sendMessage(Long chatId, String text) {

    }

    @Override
    public Page<ChatMessage> receiveMessages(Long chatId, Pageable pageable) {
        return null;
    }
}
