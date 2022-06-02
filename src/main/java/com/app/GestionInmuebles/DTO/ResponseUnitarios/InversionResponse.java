package com.app.GestionInmuebles.DTO.ResponseUnitarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InversionResponse {
    private float compra;
    private float inversiones;
    private float total;
}
