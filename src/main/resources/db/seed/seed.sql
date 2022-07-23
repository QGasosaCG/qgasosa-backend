INSERT INTO address(id, name, latitude, longitude)
VALUES (nextval('address_id_seq'), 'RUA ALICE MENEZES DOS SANTOS, 45', '-7.2556841','-35.927565') ON CONFLICT DO NOTHING;

INSERT INTO address(id, name, latitude, longitude)
VALUES (nextval('address_id_seq'), 'RUA QUEBRA QUILOS, 47',  '-7.2209854', '-35.8777024') ON CONFLICT DO NOTHING;

INSERT INTO address(id, name, latitude, longitude)
VALUES (nextval('address_id_seq'), 'RUA JOAO ALVES DE OLIVEIRA, 327',  '-7.2132129', '-35.8865126') ON CONFLICT DO NOTHING;

INSERT INTO address(id, name, latitude, longitude)
VALUES (nextval('address_id_seq'), 'RUA EPITACIO PESSOA, 350',  '-7.2141857', '-35.8903657') ON CONFLICT DO NOTHING;

INSERT INTO address(id, name, latitude, longitude)
VALUES (nextval('address_id_seq'), 'RUA DR VASCONCELOS, 127',  '-7.2113462', '-35.8859378') ON CONFLICT DO NOTHING;

INSERT INTO address(id, name, latitude, longitude)
VALUES (nextval('address_id_seq'), 'RUA TAVARES CAVALCANTE, 655 TERREO',  '-7.217841', '-35.8783067') ON CONFLICT DO NOTHING;

INSERT INTO address(id, name, latitude, longitude)
VALUES (nextval('address_id_seq'), 'AVENIDA PROFESSOR ALMEIDA BARRETO, 201',  '-7.2276026', '-35.8883221') ON CONFLICT DO NOTHING;

INSERT INTO address(id, name, latitude, longitude)
VALUES (nextval('address_id_seq'), 'RUA JOAO SUASSUNA, 579',  '-7.2152638', '-35.8926009') ON CONFLICT DO NOTHING;

INSERT INTO address(id, name, latitude, longitude)
VALUES (nextval('address_id_seq'), 'EPP	RUA ISABEL BARBOSA DE ARAUJO, SN',  '-7.2479035', '-35.8723009') ON CONFLICT DO NOTHING;

INSERT INTO address(id, name, latitude, longitude)
VALUES (nextval('address_id_seq'), 'RUA EPITACIO PESSOA, 385',  '-7.2187815', '-35.8971312') ON CONFLICT DO NOTHING;

INSERT INTO address(id, name, latitude, longitude)
VALUES (nextval('address_id_seq'), 'AVENIDA FRANCISCO LOPES DE ALMEIDA, 1665',  '-7.2510938', '-35.9283333') ON CONFLICT DO NOTHING;

INSERT INTO address(id, name, latitude, longitude)
VALUES (nextval('address_id_seq'), 'AVENIDA DEPUTADO RAIMUNDO ASFORA, SN',  '-7.2489272', '-35.92124') ON CONFLICT DO NOTHING;

INSERT INTO address(id, name, latitude, longitude)
VALUES (nextval('address_id_seq'), 'AVENIDA PRESIDENTE JUSCELINO KUBITSCHEK, 3000',  '-7.2612248', '-35.9142955') ON CONFLICT DO NOTHING;

INSERT INTO gas_station(id, name, address_id)
VALUES (nextval('gas_station_id_seq'), 'R & A COMERCIO DE COMBUSTIVEIS LTDA', 1) ON CONFLICT DO NOTHING;

INSERT INTO gas_station(id, name, address_id)
VALUES (nextval('gas_station_id_seq'), 'A. SOUZA FECHINE & CIA LTDA', 2) ON CONFLICT DO NOTHING;

INSERT INTO gas_station(id, name, address_id)
VALUES (nextval('gas_station_id_seq'), 'COMERCIAL DE COMBUSTIVEIS BORBOREMA LTDA', 3) ON CONFLICT DO NOTHING;

INSERT INTO gas_station(id, name, address_id)
VALUES (nextval('gas_station_id_seq'), 'W A BARRETO E CIA LTDA', 4) ON CONFLICT DO NOTHING;

INSERT INTO gas_station(id, name, address_id)
VALUES (nextval('gas_station_id_seq'), 'POSTO DE COMBUSTIVEIS ANEL DO BREJO LTDA', 5) ON CONFLICT DO NOTHING;

INSERT INTO gas_station(id, name, address_id)
VALUES (nextval('gas_station_id_seq'), 'F SANTOS & CIA LTDA', 6) ON CONFLICT DO NOTHING;

INSERT INTO gas_station(id, name, address_id)
VALUES (nextval('gas_station_id_seq'), 'POSTO DE COMBUSTÍVEIS MARÍLIA LTDA', 7) ON CONFLICT DO NOTHING;

INSERT INTO gas_station(id, name, address_id)
VALUES (nextval('gas_station_id_seq'), 'COMERCIAL DE COMBUSTIVEIS NORDESTE LTDA', 8) ON CONFLICT DO NOTHING;

INSERT INTO gas_station(id, name, address_id)
VALUES (nextval('gas_station_id_seq'), 'GS COMERCIO DE COMBUSTIVEIS E LUBRIFICANTES LTDA', 9) ON CONFLICT DO NOTHING;

INSERT INTO gas_station(id, name, address_id)
VALUES (nextval('gas_station_id_seq'), 'JOSEFA VANIA MEIRA DE FREITAS ON CONFLICT DO NOTHING;	RUA EPITACIO PESSOA', 10) ON CONFLICT DO NOTHING;

INSERT INTO gas_station(id, name, address_id)
VALUES (nextval('gas_station_id_seq'), 'DJ COMBUSTIVEIS LTDA ON CONFLICT DO NOTHING;	AVENIDA FRANCISCO LOPES DE ALMEIDA', 11) ON CONFLICT DO NOTHING;

INSERT INTO gas_station(id, name, address_id)
VALUES (nextval('gas_station_id_seq'), 'BARROS COMERCIO DE COMBUSTIVEL E CONVENIENCIA LTDA', 12) ON CONFLICT DO NOTHING;

INSERT INTO gas_station(id, name, address_id)
VALUES (nextval('gas_station_id_seq'), 'RODOPARAIBA COMERCIO DE COMBUSTIVEIS LTDA', 13) ON CONFLICT DO NOTHING;

INSERT INTO fuel (id, name)
VALUES (nextval('fuel_id_seq'), 'GASOLINA COMUM') ON CONFLICT DO NOTHING;

INSERT INTO fuel (id, name)
VALUES (nextval('fuel_id_seq'), 'GLP') ON CONFLICT DO NOTHING;

INSERT INTO fuel (id, name)
VALUES (nextval('fuel_id_seq'), 'OLEO DIESEL S10') ON CONFLICT DO NOTHING;

INSERT INTO fuel (id, name)
VALUES (nextval('fuel_id_seq'), 'OLEO DIESEL') ON CONFLICT DO NOTHING;

INSERT INTO fuel (id, name)
VALUES (nextval('fuel_id_seq'), 'GASOLINA ADITIVADA') ON CONFLICT DO NOTHING;

INSERT INTO fuel (id, name)
VALUES (nextval('fuel_id_seq'), 'ETANOL HIDRATADO') ON CONFLICT DO NOTHING;

INSERT INTO fuel (id, name)
VALUES (nextval('fuel_id_seq'), 'GNV') ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 1, 1, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 1, 2, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 1, 3, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 1, 4, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 1, 5, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 1, 6, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 1, 7, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 2, 1, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 2, 2, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 2, 3, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 2, 4, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 2, 5, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 2, 6, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 2, 7, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 3, 1, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 3, 2, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 3, 3, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 3, 4, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 3, 5, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 3, 6, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 3, 7, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 4, 1, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 4, 2, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 4, 3, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 4, 4, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 4, 5, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 4, 6, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 4, 7, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 5, 1, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 5, 2, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 5, 3, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 5, 4, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 5, 5, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 5, 6, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 5, 7, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 6, 1, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 6, 2, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 6, 3, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 6, 4, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 6, 5, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 6, 6, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 6, 7, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 7, 1, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 7, 2, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 7, 3, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 7, 4, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 7, 5, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 7, 6, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 7, 7, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 8, 1, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 8, 2, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 8, 3, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 8, 4, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 8, 5, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 8, 6, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 8, 7, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 9, 1, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 9, 2, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 9, 3, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 9, 4, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 9, 5, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 9, 6, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 9, 7, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 10, 1, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 10, 2, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 10, 3, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 10, 4, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 10, 5, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 10, 6, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 10, 7, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 11, 1, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 11, 2, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 11, 3, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 11, 4, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 11, 5, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 11, 6, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 11, 7, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 12, 1, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 12, 2, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 12, 3, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 12, 4, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 12, 5, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 12, 6, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 12, 7, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 13, 1, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 13, 2, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 13, 3, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 13, 4, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 13, 5, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 13, 6, 0) ON CONFLICT DO NOTHING;

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (nextval('gas_station_fuel_id_seq'), 13, 7, 0) ON CONFLICT DO NOTHING;

INSERT INTO admin (id, username, password)
VALUES (nextval('admin_id_seq'), 'admin', '$2y$10$44Wql2KK4WPgO.tFGxnSbuTqjpGkPgbzt2fEgdPR/Y0G55B06Sj3K') ON CONFLICT DO NOTHING;