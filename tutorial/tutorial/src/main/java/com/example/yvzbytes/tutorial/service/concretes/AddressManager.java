package com.example.yvzbytes.tutorial.service.concretes;

import com.example.yvzbytes.tutorial.repository.AddressRepository;
import com.example.yvzbytes.tutorial.service.abstracts.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressManager implements AddressService {
    private final AddressRepository addressRepository;
}
