package ru.diamond.mainapi.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import ru.diamond.mainapi.dtos.PrintDto;
import ru.diamond.mainapi.entities.Print;

@Mapper(componentModel = "spring")
public interface PrintMapper {
    PrintDto toPrintDto(Print color);
    List<PrintDto> toListPrintDto(List<Print> colorSet);
}
