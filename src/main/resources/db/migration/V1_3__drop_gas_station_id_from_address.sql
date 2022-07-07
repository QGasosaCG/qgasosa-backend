ALTER TABLE address
    DROP CONSTRAINT fk_address_on_gasstation;

ALTER TABLE address
    DROP COLUMN gas_station_id;