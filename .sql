create table trip_import(
placa 				varchar not null,
qtade_viagem    	int4, 
km_percorrido		int4,
tempo_movimento 	int4, 
tempo_parado		int4, 
mes_viagem 			int4,
data_processamento  date);

truncate table trip_import;

insert into trip_import (placa, qtade_viagem, km_percorrido, tempo_movimento, tempo_parado, mes_viagem, data_processamento)
select  				
plate, 
count(id),
sum(total_distance),
sum(total_moving),
sum(total_idle),
extract(month from current_date),
current_date
from trip
group by plate, current_date;
