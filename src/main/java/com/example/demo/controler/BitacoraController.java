package com.example.demo.controler;

import com.example.demo.dto.BitacoraFullDto;
import com.example.demo.model.Bitacora;
import com.example.demo.service.BitacoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Aristo/api/bitacora")
@RequiredArgsConstructor
public class BitacoraController {

    private final BitacoraService bitacoraService;

    @GetMapping
    public ResponseEntity<List<BitacoraFullDto>> getAll() {
        return ResponseEntity.ok(
                bitacoraService.getAll().stream().map(b -> {
                    var f = b.getFolio();
                    var gt = b.getGastoTotal();
                    var i = b.getInicio();
                    var k = b.getKilometraje();
                    var perfil = i != null ? i.getPerfilRegistro() : null;

                    return BitacoraFullDto.builder()
                            .id(b.getId())
                            .idFolio(f != null ? f.getFolio() : null)
                            .folio(f != null ? f.getFolio().toString() : null)

                            .idGastoTotal(gt != null ? gt.getId() : null)
                            .gastoTotal(gt != null ? gt.getGastoTotal() : null)
                            .casetasE(gt != null && gt.getGastosE() != null ? gt.getGastosE().getCasetas() : null)
                            .combustibleE(gt != null && gt.getGastosE() != null ? gt.getGastosE().getCombustible() : null)
                            .comidas(gt != null && gt.getGastosE() != null ? gt.getGastosE().getComidas() : null)
                            .maniobras(gt != null && gt.getGastosE() != null ? gt.getGastosE().getManiobras() : null)
                            .reparaciones(gt != null && gt.getGastosE() != null ? gt.getGastosE().getReparaciones() : null)
                            .totale(gt != null && gt.getGastosE() != null ? gt.getGastosE().getTotale() : null)
                            .transitofederal(gt != null && gt.getGastosE() != null ? gt.getGastosE().getTransitofederal() : null)
                            .casetasT(gt != null && gt.getGastosT() != null ? gt.getGastosT().getCasetas() : null)
                            .combustibleT(gt != null && gt.getGastosT() != null ? gt.getGastosT().getCombustible() : null)
                            .totalt(gt != null && gt.getGastosT() != null ? gt.getGastosT().getTotalT() : null)

                            .idInicio(i != null ? i.getId() : null)
                            .cliente(i != null ? i.getCliente() : null)
                            .destino(i != null ? i.getDestino() : null)
                            .fecha(i != null ? i.getFecha() : null)

                            .telefonoPerfilRegistro(perfil != null ? perfil.getTelefono() : null)
                            .nombreOperador(perfil != null ? perfil.getNombre() : null)
                            .unidadEco(perfil != null ? perfil.getNss() : null)

                            .nombresAyudantes(i != null && i.getAyudantes() != null
                                    ? i.getAyudantes().stream().map(a -> a.getNombre()).toList()
                                    : List.of())

                            .idKilometraje(k != null ? k.getId() : null)
                            .combustibleConsumido(k != null ? k.getCombustibleConsumido() : null)
                            .distanciaTotal(k != null ? k.getDistanciaTotal() : null)
                            .odometroFinal(k != null ? k.getOdometroFinal() : null)
                            .odometroInicial(k != null ? k.getOdometroInicial() : null)
                            .rendimiento(k != null ? k.getRendimiento() : null)

                            .build();
                }).collect(Collectors.toList())
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<BitacoraFullDto> getById(@PathVariable Integer id) {
        Bitacora b = bitacoraService.getById(id);
        if (b == null) {
            return ResponseEntity.notFound().build();
        }

        var f = b.getFolio();
        var gt = b.getGastoTotal();
        var i = b.getInicio();
        var k = b.getKilometraje();
        var perfil = i != null ? i.getPerfilRegistro() : null;

        return ResponseEntity.ok(BitacoraFullDto.builder()
                .idFolio(f != null ? f.getFolio() : null)
                .folio(f != null ? f.getFolio().toString() : null)

                .idGastoTotal(gt != null ? gt.getId() : null)
                .gastoTotal(gt != null ? gt.getGastoTotal() : null)
                .casetasE(gt != null && gt.getGastosE() != null ? gt.getGastosE().getCasetas() : null)
                .combustibleE(gt != null && gt.getGastosE() != null ? gt.getGastosE().getCombustible() : null)
                .comidas(gt != null && gt.getGastosE() != null ? gt.getGastosE().getComidas() : null)
                .maniobras(gt != null && gt.getGastosE() != null ? gt.getGastosE().getManiobras() : null)
                .reparaciones(gt != null && gt.getGastosE() != null ? gt.getGastosE().getReparaciones() : null)
                .totale(gt != null && gt.getGastosE() != null ? gt.getGastosE().getTotale() : null)
                .transitofederal(gt != null && gt.getGastosE() != null ? gt.getGastosE().getTransitofederal() : null)
                .casetasT(gt != null && gt.getGastosT() != null ? gt.getGastosT().getCasetas() : null)
                .combustibleT(gt != null && gt.getGastosT() != null ? gt.getGastosT().getCombustible() : null)
                .totalt(gt != null && gt.getGastosT() != null ? gt.getGastosT().getTotalT() : null)

                .idInicio(i != null ? i.getId() : null)
                .cliente(i != null ? i.getCliente() : null)
                .destino(i != null ? i.getDestino() : null)
                .fecha(i != null ? i.getFecha() : null)

                .telefonoPerfilRegistro(perfil != null ? perfil.getTelefono() : null)
                .nombreOperador(perfil != null ? perfil.getNombre() : null)
                .unidadEco(perfil != null ? perfil.getNss() : null)

                .nombresAyudantes(i != null && i.getAyudantes() != null
                        ? i.getAyudantes().stream().map(a -> a.getNombre()).toList()
                        : List.of())

                .idKilometraje(k != null ? k.getId() : null)
                .combustibleConsumido(k != null ? k.getCombustibleConsumido() : null)
                .distanciaTotal(k != null ? k.getDistanciaTotal() : null)
                .odometroFinal(k != null ? k.getOdometroFinal() : null)
                .odometroInicial(k != null ? k.getOdometroInicial() : null)
                .rendimiento(k != null ? k.getRendimiento() : null)

                .build());
    }



}