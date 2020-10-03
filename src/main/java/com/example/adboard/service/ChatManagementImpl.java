package com.example.adboard.service;

import com.example.adboard.domain.chat.Chat;
import com.example.adboard.domain.chat.ChatMessage;
import com.example.adboard.domain.chat.ChatRepository;
import com.example.adboard.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ChatManagementImpl implements ChatManagement {

    private final ChatRepository chatRepository;

    private final UserService userService;

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER') and not #principal.username.equalsIgnoreCase(#addressed.username)")
    public Chat create(User addressed) {
        User currentUser = userService.getCurrentUser();
        Optional<Chat> optional =
                chatRepository.findByMembersContainsAndMembersContains(currentUser, addressed);

        Assert.state(optional.isEmpty(), "Chat already exists");

        Chat chat = new Chat();
        chat.setMembers(Set.of(currentUser, addressed));

        return chatRepository.save(chat);
    }

    @Override
    public void sendMessage(Long chatId, String text) {

    }

    @Override
    public Page<ChatMessage> receiveMessages(Long chatId, Pageable pageable) {
        return null;
    }
}
