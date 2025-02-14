package com.example.lojas.saines.dto;

import com.example.lojas.saines.entity.Paper;
import com.example.lojas.saines.enuns.UserPaper;

public record UserRequestDTO(String nome, String email, String password, Paper paper){
}
