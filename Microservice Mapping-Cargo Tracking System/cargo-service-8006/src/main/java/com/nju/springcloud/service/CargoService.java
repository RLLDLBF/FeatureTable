package com.nju.springcloud.service;

import com.nju.springcloud.entities.cargoVersion2.CargoVersion2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CargoService {

    /**
     * list all cargos
     * @return
     */
    public List<CargoVersion2> ListAllCargos();

    /**
     * view details for cargo by cargoId
     * @param trackingId
     * @return
     */
    public CargoVersion2 ViewDetailsForCargo(@Param("trackingId") String trackingId);

    /**
     * book new cargo
     * @param cargo
     * @return
     */
    public int BookCargo(CargoVersion2 cargo);

    /**
     * change cargo destination by trackingId
     * @param cargo
     * @return
     */
    public int ChangeCargoDestination(CargoVersion2 cargo);

    /**
     * choose a route for cargo by trackingId
     * @param cargo
     * @return
     */
    public int RouteCargo(CargoVersion2 cargo);
}
