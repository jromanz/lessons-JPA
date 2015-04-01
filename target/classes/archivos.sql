 DROP PROCEDURE IF EXISTS getDoctorByCachorroRaza;
 DELIMITER $$ 
 CREATE PROCEDURE getDoctorByCachorroRaza(in raza varchar(30)) 
 begin 
 DECLARE done INT DEFAULT FALSE;
 DECLARE v_dni varchar(50);
 DECLARE v_nombre varchar(50);
 DECLARE v_raza varchar(50);
 DECLARE v_nombrecachorro varchar(50);
 
 
 --RUN SENTENCE
 declare cur_getDoctorByCachorroRaza cursor for
 select d.dni, d.nombre, c.raza, c.nombre 
 from persist_doctor d join persist_cachorro c 
 on d.doctor_id = c.doctor_id
 where c.raza = raza; 
 --END SENTENCE
 
 DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
 
 
 open cur_getDoctorByCachorroRaza;
 
 read_loop: loop
	fetch cur_getDoctorByCachorroRaza into v_dni, v_nombre, v_raza, v_nombrecachorro;
 end loop;
 
 close cur_getDoctorByCachorroRaza;
 
 END$$ DELIMITER ;