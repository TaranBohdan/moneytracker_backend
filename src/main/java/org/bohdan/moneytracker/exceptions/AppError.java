package org.bohdan.moneytracker.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class AppError
{
    private int statusCode;
    private String message;
}
