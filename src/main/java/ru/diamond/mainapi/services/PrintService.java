package ru.diamond.mainapi.services;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diamond.mainapi.dtos.PrintDto;
import ru.diamond.mainapi.mappers.PrintMapper;
import ru.diamond.mainapi.repositories.PrintRepository;

@Service
@AllArgsConstructor
public class PrintService {

    private final PrintRepository printRepository;
    private final PrintMapper printMapper;

    public Set<PrintDto> getAllPrints() {
        return new HashSet<>(printMapper.toListPrintDto(printRepository.findAll()));
    }
}
