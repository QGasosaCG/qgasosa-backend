INSERT INTO address(id, name, latitude, longitude)
VALUES (1, 'RUA ALICE MENEZES DOS SANTOS, 45', '-7.2556841','-35.927565');

INSERT INTO address(id, name, latitude, longitude)
VALUES (2, 'RUA QUEBRA QUILOS, 47',  '-7.2209854', '-35.8777024');

INSERT INTO address(id, name, latitude, longitude)
VALUES (3, 'RUA JOAO ALVES DE OLIVEIRA, 327',  '-7.2132129', '-35.8865126');

INSERT INTO address(id, name, latitude, longitude)
VALUES (4, 'RUA EPITACIO PESSOA, 350',  '-7.2141857', '-35.8903657');

INSERT INTO address(id, name, latitude, longitude)
VALUES (5, 'RUA DR VASCONCELOS, 127',  '-7.2113462', '-35.8859378');

INSERT INTO address(id, name, latitude, longitude)
VALUES (6, 'RUA TAVARES CAVALCANTE, 655 TERREO',  '-7.217841', '-35.8783067');

INSERT INTO address(id, name, latitude, longitude)
VALUES (7, 'AVENIDA PROFESSOR ALMEIDA BARRETO, 201',  '-7.2276026', '-35.8883221');

INSERT INTO address(id, name, latitude, longitude)
VALUES (8, 'RUA JOAO SUASSUNA, 579',  '-7.2152638', '-35.8926009');

INSERT INTO address(id, name, latitude, longitude)
VALUES (9, 'EPP	RUA ISABEL BARBOSA DE ARAUJO, SN',  '-7.2479035', '-35.8723009');

INSERT INTO address(id, name, latitude, longitude)
VALUES (10, 'RUA EPITACIO PESSOA, 385',  '-7.2187815', '-35.8971312');

INSERT INTO address(id, name, latitude, longitude)
VALUES (11, 'AVENIDA FRANCISCO LOPES DE ALMEIDA, 1665',  '-7.2510938', '-35.9283333');

INSERT INTO address(id, name, latitude, longitude)
VALUES (12, 'AVENIDA DEPUTADO RAIMUNDO ASFORA, SN',  '-7.2489272', '-35.92124');

INSERT INTO address(id, name, latitude, longitude)
VALUES (13, 'AVENIDA PRESIDENTE JUSCELINO KUBITSCHEK, 3000',  '-7.2612248', '-35.9142955');

INSERT INTO gas_station(id, name, address_id)
VALUES (1, 'R & A COMERCIO DE COMBUSTIVEIS LTDA', 1);

INSERT INTO gas_station(id, name, address_id)
VALUES (2, 'A. SOUZA FECHINE & CIA LTDA', 2);

INSERT INTO gas_station(id, name, address_id)
VALUES (3, 'COMERCIAL DE COMBUSTIVEIS BORBOREMA LTDA', 3);

INSERT INTO gas_station(id, name, address_id)
VALUES (4, 'W A BARRETO E CIA LTDA', 4);

INSERT INTO gas_station(id, name, address_id)
VALUES (5, 'POSTO DE COMBUSTIVEIS ANEL DO BREJO LTDA', 5);

INSERT INTO gas_station(id, name, address_id)
VALUES (6, 'F SANTOS & CIA LTDA', 6);

INSERT INTO gas_station(id, name, address_id)
VALUES (7, 'POSTO DE COMBUSTÍVEIS MARÍLIA LTDA', 7);

INSERT INTO gas_station(id, name, address_id)
VALUES (8, 'COMERCIAL DE COMBUSTIVEIS NORDESTE LTDA', 8);

INSERT INTO gas_station(id, name, address_id)
VALUES (9, 'GS COMERCIO DE COMBUSTIVEIS E LUBRIFICANTES LTDA', 9);

INSERT INTO gas_station(id, name, address_id)
VALUES (10, 'JOSEFA VANIA MEIRA DE FREITAS;	RUA EPITACIO PESSOA', 10);

INSERT INTO gas_station(id, name, address_id)
VALUES (11, 'DJ COMBUSTIVEIS LTDA;	AVENIDA FRANCISCO LOPES DE ALMEIDA', 11);

INSERT INTO gas_station(id, name, address_id)
VALUES (12, 'BARROS COMERCIO DE COMBUSTIVEL E CONVENIENCIA LTDA', 12);

INSERT INTO gas_station(id, name, address_id)
VALUES (13, 'RODOPARAIBA COMERCIO DE COMBUSTIVEIS LTDA', 13);

INSERT INTO fuel (id, name)
VALUES (1, 'GASOLINA COMUM');

INSERT INTO fuel (id, name)
VALUES (2, 'GLP');

INSERT INTO fuel (id, name)
VALUES (3, 'OLEO DIESEL S10');

INSERT INTO fuel (id, name)
VALUES (4, 'OLEO DIESEL');

INSERT INTO fuel (id, name)
VALUES (5, 'GASOLINA ADITIVADA');

INSERT INTO fuel (id, name)
VALUES (6, 'ETANOL HIDRATADO');

INSERT INTO fuel (id, name)
VALUES (7, 'GNV');

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (1, 1, 1, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (2, 1, 2, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (3, 1, 3, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (4, 1, 4, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (5, 1, 5, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (6, 1, 6, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (7, 1, 7, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (8, 2, 1, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (9, 2, 2, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (10, 2, 3, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (11, 2, 4, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (12, 2, 5, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (13, 2, 6, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (14, 2, 7, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (15, 3, 1, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (16, 3, 2, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (17, 3, 3, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (18, 3, 4, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (19, 3, 5, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (20, 3, 6, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (21, 3, 7, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (22, 4, 1, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (23, 4, 2, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (24, 4, 3, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (25, 4, 4, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (26, 4, 5, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (27, 4, 6, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (28, 4, 7, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (29, 5, 1, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (30, 5, 2, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (31, 5, 3, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (32, 5, 4, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (33, 5, 5, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (34, 5, 6, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (35, 5, 7, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (36, 6, 1, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (37, 6, 2, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (38, 6, 3, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (39, 6, 4, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (40, 6, 5, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (41, 6, 6, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (42, 6, 7, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (43, 7, 1, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (44, 7, 2, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (45, 7, 3, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (46, 7, 4, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (47, 7, 5, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (48, 7, 6, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (49, 7, 7, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (50, 8, 1, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (51, 8, 2, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (52, 8, 3, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (53, 8, 4, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (54, 8, 5, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (55, 8, 6, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (56, 8, 7, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (57, 9, 1, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (58, 9, 2, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (59, 9, 3, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (60, 9, 4, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (61, 9, 5, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (62, 9, 6, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (63, 9, 7, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (64, 10, 1, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (65, 10, 2, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (66, 10, 3, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (67, 10, 4, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (68, 10, 5, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (69, 10, 6, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (70, 10, 7, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (71, 11, 1, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (72, 11, 2, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (73, 11, 3, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (74, 11, 4, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (75, 11, 5, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (76, 11, 6, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (77, 11, 7, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (78, 12, 1, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (79, 12, 2, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (80, 12, 3, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (81, 12, 4, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (82, 12, 5, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (83, 12, 6, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (84, 12, 7, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (85, 13, 1, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (86, 13, 2, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (87, 13, 3, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (88, 13, 4, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (89, 13, 5, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (90, 13, 6, 0);

INSERT INTO gas_station_fuel (id, gas_station_id, fuel_id, price)
VALUES (91, 13, 7, 0);
