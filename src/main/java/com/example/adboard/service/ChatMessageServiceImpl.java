package com.example.adboard.service;

import com.example.adboard.domain.chat.Chat;
import com.example.adboard.domain.chat.ChatMessage;
import com.example.adboard.domain.chat.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public void create(Chat chat, String text) {
        ChatMessage message = new ChatMessage();
        message.setText(text);
        message.setChat(chat);
        chatMessageRepository.save(message);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public Page<ChatMessage> getPageMessages(Chat chat, Pageable pageable) {
        return chatMessageRepository.findAllByChat(chat, pageable);
    }
}
