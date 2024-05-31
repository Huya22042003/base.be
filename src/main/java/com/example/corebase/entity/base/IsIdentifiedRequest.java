package com.example.corebase.entity.base;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class IsIdentifiedRequest {
    private UUID id;
}
