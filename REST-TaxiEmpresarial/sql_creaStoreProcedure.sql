
CREATE PROCEDURE usp_ActualizaEncuesta
  @codReserva INT,
  @cal_p1 VARCHAR(50),
  @cal_p2 VARCHAR(250)
AS
BEGIN
  UPDATE tb_calificacion
  SET cal_fecha_fin=GETDATE(), cal_preg01=@cal_p1,cal_preg02=@cal_p2, cal_estado=2
  WHERE cod_reserva=@codReserva
END

CREATE PROCEDURE usp_CreaEncuesta
  @codReserva INT
AS
BEGIN
  INSERT INTO tb_calificacion (cod_reserva,cal_fecha_ini, cal_estado) 
  VALUES (@codReserva,GETDATE(),1)
END

CREATE PROCEDURE usp_ConsultaEncuesta
  @codReserva INT
AS
BEGIN
  SELECT cod_reserva,cal_fecha_ini,cal_fecha_fin,cal_preg01,cal_preg02,cal_estado FROM tb_calificacion
  WHERE cod_reserva = @codReserva
END