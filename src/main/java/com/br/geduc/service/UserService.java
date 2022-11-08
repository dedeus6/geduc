package com.br.geduc.service;

import com.br.geduc.document.UserDocument;
import com.br.geduc.dto.request.UserAuthRequestDTO;
import com.br.geduc.dto.request.UserRequestDTO;
import com.br.geduc.dto.request.UserUpdateRequestDTO;
import com.br.geduc.dto.response.UserResponseDTO;
import com.br.geduc.exceptions.BusinessException;
import com.br.geduc.mapper.UserMapper;
import com.br.geduc.repository.SubscriberRepository;
import com.br.geduc.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import static com.br.geduc.constants.Errors.*;

@AllArgsConstructor
@Slf4j
public class UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    private SubscriberRepository subscriberRepository;

    public void createUser(UserRequestDTO user) {
        var userByRegistration = getUserByRegistration(user.getRegistration());
        if (!Objects.isNull(userByRegistration))
            throw new BusinessException(USER_ALREADY_EXIST);

        var userByEmail = getUserByEmail(user.getEmail());
        if (!Objects.isNull(userByEmail))
            throw new BusinessException(EMAIL_ALREADY_USE);

        var userDocument = userMapper.toDocument(user);
        userDocument.setIsAdmin(false);
        userRepository.save(userDocument);
    }

    public UserResponseDTO authUser(UserAuthRequestDTO userRequest) {
        var user = getUserByRegistration(userRequest.getRegistration());

        if (Objects.isNull(user))
            throw new BusinessException(USER_NOT_EXIST);

        if (!user.getPassword().equals(userRequest.getPassword()))
            throw new BusinessException(INVALID_PASSWORD);

        return user;
    }

    public UserResponseDTO getUserByRegistration(String registration) {
        return userRepository.findByRegistration(registration);
    }

    protected void validateIfUserAlreadySubscribeInEvent(String eventNumber, String registration) {
        var document = subscriberRepository.findByEventNumberAndRegistration(eventNumber, registration);

        if (Objects.nonNull(document))
            throw new BusinessException(USER_ALREADY_SUBSCRIBE);
    }

    public UserResponseDTO updateUser(String registration, UserUpdateRequestDTO request) {
        var oldUser = getUserByRegistration(registration);

        if (Objects.isNull(oldUser))
            throw new BusinessException(USER_NOT_EXIST);

        var userDocument = UserDocument.builder()
                .id(oldUser.getId())
                .registration(oldUser.getRegistration())
                .name(oldUser.getName())
                .password(oldUser.getPassword())
                .email(oldUser.getEmail())
                .isAdmin(oldUser.getIsAdmin())
                .techs(request.getTechs())
                .build();

        var newUser = userRepository.save(userDocument);

        return userMapper.toResponse(newUser);
    }

    public UserResponseDTO getUser(String registration) {
        var user = userRepository.findByRegistration(registration);
        if (Objects.isNull(user))
            throw new BusinessException(USER_NOT_EXIST);
        return user;
    }

    private UserResponseDTO getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
