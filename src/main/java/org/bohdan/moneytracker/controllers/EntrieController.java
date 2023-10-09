package org.bohdan.moneytracker.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.handlers.ResponseHandler;
import org.bohdan.moneytracker.mappers.EntrieMapper;
import org.bohdan.moneytracker.models.dtos.EntrieCreateDto;
import org.bohdan.moneytracker.models.dtos.EntrieDto;
import org.bohdan.moneytracker.models.entities.Entrie;
import org.bohdan.moneytracker.services.EntrieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wallets/{id}/entries")
@RequiredArgsConstructor
@Tag(name = "Entrie", description = "Entrie management")
public class EntrieController
{
    private final EntrieService entrieService;
    private final EntrieMapper entrieMapper;

    @Operation(description = "Get all entries")
    @ApiResponse(responseCode = "200", description = "Entries found")
    @GetMapping("")
    public ResponseEntity<?> getAll()
    {
        try
        {
            List<Entrie> entries = entrieService.getAll();
            List<EntrieDto> entrieDtos = entrieMapper.toDtoList(entries);
            return ResponseHandler.generateResponse(
                    "Successfully retrieved data!",
                    HttpStatus.OK,
                    entrieDtos,
                    "entries");
        }
        catch (Exception e)
        {
            return ResponseHandler.generateError("Entries were not found!", HttpStatus.NOT_FOUND);
        }
    }

    @Operation(description = "Get all entries")
    @ApiResponse(responseCode = "200", description = "Entries found")
    @PostMapping("")
    public ResponseEntity<?> createEntrie(@RequestBody EntrieCreateDto entrieCreateDto)
    {
        return null;
    }
}
