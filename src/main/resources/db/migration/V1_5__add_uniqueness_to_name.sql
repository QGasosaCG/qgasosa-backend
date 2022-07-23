ALTER TABLE fuel
    ADD CONSTRAINT uc_fuel_name UNIQUE (name);

ALTER TABLE gas_station
    ADD CONSTRAINT uc_gasstation_name UNIQUE (name);