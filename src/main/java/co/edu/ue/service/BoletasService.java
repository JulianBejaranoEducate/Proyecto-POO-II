package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IBoletasDao;
import co.edu.ue.entity.Boletas;

@Service
public class BoletasService implements IBoletasService{

	@Autowired
	IBoletasDao boletasDao;

	@Override
	public List<Boletas> listAll() {
		return boletasDao.listaCompleta();
	}

	@Override
	public Boletas addBoleta(Boletas boleta) {
		return boletasDao.guardarBoleta(boleta);
	}

	@Override
	public Boletas updateBoleta(Boletas boleta) {
		return boletasDao.actualizarBoleta(boleta);
	}

	@Override
	public Boletas findBoletaById(int id) {
		return boletasDao.encontrarBoletaId(id);
	}

	@Override
	public void deleteBoletaById(int id) {
		boletasDao.eliminarBoletaId(id);
	}

}
