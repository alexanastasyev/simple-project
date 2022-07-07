package dev.alexanastasyev.simpleproject.controller;

import dev.alexanastasyev.simpleproject.service.CurrentTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrentTimeController {

    private static final String FORMAT_VALUE_TRUE = "true";
    private static final String FORMAT_VALUE_FALSE = "false";
    private static final String FORMAT_ERROR = "Invalid name of parameter \"format\"";

    private final CurrentTimeService currentTimeService;

    @GetMapping("/current-time")
    public ResponseEntity<String> getCurrentTime(@RequestParam(defaultValue = FORMAT_VALUE_TRUE) String format) {
        switch (format) {
            case FORMAT_VALUE_TRUE:
                return ResponseEntity.ok( currentTimeService.getCurrentTimeFormatted() );
            case FORMAT_VALUE_FALSE:
                return ResponseEntity.ok( String.valueOf(currentTimeService.getCurrentTimeMillis()) );
            default:
                return ResponseEntity.badRequest().body(FORMAT_ERROR);
        }
    }

}
