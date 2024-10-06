package ar.edu.unlam.pb2.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.dominio.entidades.Producto;
import ar.edu.unlam.pb2.dominio.enums.Tamanio;
import ar.edu.unlam.pb2.dominio.enums.TipoBebida;
import ar.edu.unlam.pb2.dominio.entidades.Bebida;
import ar.edu.unlam.pb2.dominio.entidades.Cliente;
import ar.edu.unlam.pb2.dominio.entidades.Hamburguesa;
import ar.edu.unlam.pb2.dominio.entidades.PapaFrita;
import ar.edu.unlam.pb2.dominio.entidades.Pedido;

public class HamburgueseriaTest {

	/*
	 * Herencia y polimorfismo (simples, interfaces, abstractas) Colecciones -> List
	 * TDD Manejo clientes. empezar por cliente (parte de hmbimpl) coleccion
	 * clientes, coleecion pedidos.
	 * 
	 * Armar pedido -> Un pedido tiene un cliente y una coleccion de productos.
	 * Obtener el precio del pedido
	 */

	/*
	 * Vende comida -> hamburguesas (veganos), papas fritas, panchos (veganos) Vende
	 * bebidas -> aguas, jugos, gaseosas, bebidas alcoholicas Tiene clientes.
	 */

	private HamburgueseriaImpl hamburgueseria;

	@Before
	public void init() {
		this.hamburgueseria = new HamburgueseriaImpl();
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaCuandoQuieroAgregarUnProductoHamburguesaObtengoVerdadero() {
		Producto hamburguesa = new Hamburguesa();

		Boolean productoAgregado = this.hamburgueseria.agregarProducto(hamburguesa);

		assertTrue(productoAgregado);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaConDosHamburguesasCuandoObtengoLasHamburguesasLaColeccionContieneDosHamburugesas() {
		Producto hamburguesa = new Hamburguesa();
		hamburguesa.setNombre("Simple");
		Producto otraHamburguesa = new Hamburguesa();
		otraHamburguesa.setNombre("Completa");

		hamburgueseria.agregarProducto(hamburguesa);
		hamburgueseria.agregarProducto(otraHamburguesa);

		List<Producto> comidasObtenidas = this.hamburgueseria.obtener();
		int cantidadEsperada = 2;

		String nombreSimpleEsperado = "Simple";
		String nombreCompletaEsperado = "Completa";

		assertEquals(cantidadEsperada, comidasObtenidas.size());
		assertEquals(nombreSimpleEsperado, comidasObtenidas.get(0).getNombre());
		assertEquals(nombreCompletaEsperado, comidasObtenidas.get(1).getNombre());
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaConUnaHamburguesaDeCarneYOtraHamburguesaVeganaCuandoObtengoLasHamburguesasLaColeccionContieneDosHamburugesasUnaDeCarneYOtraVegana() {
		Hamburguesa hamburguesa = new Hamburguesa();
		hamburguesa.setNombre("Simple");
		hamburguesa.esVegana(false);
		Hamburguesa otraHamburguesa = new Hamburguesa();
		otraHamburguesa.setNombre("Completa");
		otraHamburguesa.esVegana(true);

		hamburgueseria.agregarProducto(hamburguesa);
		hamburgueseria.agregarProducto(otraHamburguesa);

		List<Producto> comidasObtenidas = this.hamburgueseria.obtener();
		int cantidadEsperada = 2;

		String nombreSimpleEsperado = "Simple";
		String nombreCompletaEsperado = "Completa";

		Hamburguesa hamburguesaDeCarne = (Hamburguesa) comidasObtenidas.get(0);
		Hamburguesa hamburguesaVegana = (Hamburguesa) comidasObtenidas.get(1);

		assertEquals(cantidadEsperada, comidasObtenidas.size());
		assertEquals(nombreSimpleEsperado, hamburguesaDeCarne.getNombre());
		assertFalse(hamburguesaDeCarne.esVegana());
		assertEquals(nombreCompletaEsperado, hamburguesaVegana.getNombre());
		assertTrue(hamburguesaVegana.esVegana());
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaConUnaHamburguesaDeCarneYOtraHamburguesaVeganaCuandoObtengoLasHamburguesasVeganasLaColeccionContieneUnaHamburugesa() {
		Hamburguesa hamburguesa = new Hamburguesa();
		hamburguesa.esVegana(false);
		Hamburguesa otraHamburguesa = new Hamburguesa();
		otraHamburguesa.esVegana(true);

		hamburgueseria.agregarProducto(hamburguesa);
		hamburgueseria.agregarProducto(otraHamburguesa);

		List<Hamburguesa> hamburguesasObtenidas = this.hamburgueseria.obtenerHamburguesas(true);

		int cantidadEsperada = 1;

		Hamburguesa hamburguesaVegana = (Hamburguesa) hamburguesasObtenidas.get(0);

		assertEquals(cantidadEsperada, hamburguesasObtenidas.size());
		assertTrue(hamburguesaVegana.esVegana());
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaConUnaHamburguesaSimpleCuandoConsultoELPrecioDeLaHamburguesaSimpleObtengoOchoMil() {
		Hamburguesa hamburguesa = new Hamburguesa();
		int cantidadMedallones = 1;
		hamburguesa.setCantidadMedallones(cantidadMedallones);

		hamburgueseria.agregarProducto(hamburguesa);

		Hamburguesa otraHamburguesa = new Hamburguesa();
		otraHamburguesa.setCantidadMedallones(cantidadMedallones);

		Double precioObtenido = this.hamburgueseria.obtenerPrecioHamburguesa(otraHamburguesa);

		Double precioEsperado = 8000.0;

		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaConUnaHamburguesaDobleCuandoConsultoELPrecioDeLaHamburguesaDobleObtengoDiezMil() {
		Hamburguesa hamburguesa = new Hamburguesa();
		int cantidadMedallones = 2;
		hamburguesa.setCantidadMedallones(cantidadMedallones);

		hamburgueseria.agregarProducto(hamburguesa);

		Hamburguesa otraHamburguesa = new Hamburguesa();
		otraHamburguesa.setCantidadMedallones(cantidadMedallones);

		Double precioObtenido = this.hamburgueseria.obtenerPrecioHamburguesa(otraHamburguesa);

		Double precioEsperado = 10000.0;

		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaConUnaHamburguesaTripleCuandoConsultoELPrecioDeLaHamburguesaTripleObtengoDoceMil() {
		Hamburguesa hamburguesa = new Hamburguesa();
		int cantidadMedallones = 3;
		hamburguesa.setCantidadMedallones(cantidadMedallones);

		hamburgueseria.agregarProducto(hamburguesa);

		Hamburguesa otraHamburguesa = new Hamburguesa();
		otraHamburguesa.setCantidadMedallones(cantidadMedallones);

		Double precioObtenido = this.hamburgueseria.obtenerPrecioHamburguesa(otraHamburguesa);

		Double precioEsperado = 12000.0;

		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaConUnaHamburguesaCuadrupleCuandoConsultoELPrecioDeLaHamburguesaCuadrupleObtengoCatorceMil() {
		Hamburguesa hamburguesa = new Hamburguesa();
		int cantidadMedallones = 4;
		hamburguesa.setCantidadMedallones(cantidadMedallones);

		hamburgueseria.agregarProducto(hamburguesa);

		Hamburguesa otraHamburguesa = new Hamburguesa();
		otraHamburguesa.setCantidadMedallones(cantidadMedallones);

		Double precioObtenido = this.hamburgueseria.obtenerPrecioHamburguesa(otraHamburguesa);

		Double precioEsperado = 14000.0;

		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaCuandoAgregoProductosNoPuedoAgregarMasDeCincoProductos() {
		Producto hamburguesa = new Hamburguesa();
		hamburguesa.setNombre("Simple");
		Producto otraHamburguesa = new Hamburguesa();
		otraHamburguesa.setNombre("Completa");
		Producto hamburguesaVegana = new Hamburguesa();
		otraHamburguesa.setNombre("Vegana");
		Producto otraHamburguesaVegana = new Hamburguesa();
		otraHamburguesa.setNombre("Vegana");
		Producto hamburguesaVeganaDoble = new Hamburguesa();
		otraHamburguesa.setNombre("Vegana doble");
		Producto hamburguesaVeganaTriple = new Hamburguesa();
		otraHamburguesa.setNombre("Vegana triple");

		Boolean primerProductoAgregado = hamburgueseria.agregarProducto(hamburguesa);
		Boolean segundoProductoAgregado = hamburgueseria.agregarProducto(otraHamburguesa);
		Boolean terceroProductoAgregado = hamburgueseria.agregarProducto(hamburguesaVegana);
		Boolean cuartoProductoAgregado = hamburgueseria.agregarProducto(otraHamburguesaVegana);
		Boolean quintoProductoAgregado = hamburgueseria.agregarProducto(hamburguesaVeganaDoble);
		Boolean sextoProductoAgregado = hamburgueseria.agregarProducto(hamburguesaVeganaTriple);

		assertTrue(primerProductoAgregado);
		assertTrue(segundoProductoAgregado);
		assertTrue(terceroProductoAgregado);
		assertTrue(cuartoProductoAgregado);
		assertTrue(quintoProductoAgregado);
		assertFalse(sextoProductoAgregado);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaCuandoQuieroAgregarUnProductoPapasFritasObtengoVerdadero() {
		PapaFrita papasFritas = new PapaFrita();

		Boolean productoAgregado = this.hamburgueseria.agregarProducto(papasFritas);

		assertTrue(productoAgregado);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaConUnaPorcionDePapasFritasCuandoObtengoLasPapasFritasLaColeccionContieneUnaPorcionDePapasFritas() {
		PapaFrita papasFritas = new PapaFrita();
		PapaFrita otrasPapasFritas = new PapaFrita();

		hamburgueseria.agregarProducto(papasFritas);
		hamburgueseria.agregarProducto(otrasPapasFritas);

		List<Producto> comidasObtenidas = this.hamburgueseria.obtener();
		int cantidadEsperada = 2;

		assertEquals(cantidadEsperada, comidasObtenidas.size());
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaPuedoAgregarUnProductoPapasFritasChico() {
		PapaFrita papasFritas = new PapaFrita();
		papasFritas.setTamanio(Tamanio.CHICA);
		Boolean productoAgregado = this.hamburgueseria.agregarProducto(papasFritas);

		Tamanio tamanioEsperado = Tamanio.CHICA;
		Tamanio tamanioObtenido = papasFritas.getTamanio();
		assertTrue(productoAgregado);
		assertEquals(tamanioEsperado, tamanioObtenido);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaPuedoAgregarUnProductoPapasFritasChicoYUnoGrande() {
		PapaFrita papasFritas = new PapaFrita();
		papasFritas.setTamanio(Tamanio.CHICA);
		PapaFrita otrasPapasFritas = new PapaFrita();
		otrasPapasFritas.setTamanio(Tamanio.GRANDE);

		Tamanio tamanioEsperadoChico = Tamanio.CHICA;
		Tamanio tamanioObtenidoPapasFritas = papasFritas.getTamanio();

		Tamanio tamanioEsperadoGrande = Tamanio.GRANDE;
		Tamanio tamanioObtenidoOtrasPapasFritas = otrasPapasFritas.getTamanio();
		assertEquals(tamanioEsperadoChico, tamanioObtenidoPapasFritas);
		assertEquals(tamanioEsperadoGrande, tamanioObtenidoOtrasPapasFritas);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaUnProductoPapasFritasChicoCuandoConsultoElPrecioDeLasPapasChicasObtengoTresMil() {
		PapaFrita papasFritas = new PapaFrita();
		papasFritas.setTamanio(Tamanio.CHICA);

		hamburgueseria.agregarProducto(papasFritas);

		Double precioEsperado = 3000.0;
		Double precioObtenido = this.hamburgueseria.obtenerPrecioPapaFrita(papasFritas);

		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaUnProductoPapasFritasGrandeCuandoConsultoElPrecioDeLasPapasGrandesObtengoCincoMil() {
		PapaFrita papasFritas = new PapaFrita();
		papasFritas.setTamanio(Tamanio.GRANDE);

		hamburgueseria.agregarProducto(papasFritas);

		Double precioEsperado = 5000.0;
		Double precioObtenido = this.hamburgueseria.obtenerPrecioPapaFrita(papasFritas);

		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaCuandoQuieroAgregarUnProductoBebidaObtengoVerdadero() {
		Bebida agua = new Bebida();

		Boolean productoAgregado = this.hamburgueseria.agregarProducto(agua);

		assertTrue(productoAgregado);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaConUnProductoBebidaTamanioChicoCuandoConsultoElTamanioObtengoUnProductoBebidaTamanioChico() {
		Bebida agua = new Bebida();
		agua.setTamanio(Tamanio.CHICA);
		this.hamburgueseria.agregarProducto(agua);

		Tamanio tamanioEsperado = Tamanio.CHICA;
		Tamanio tamanioObtenido = agua.getTamanio();

		assertEquals(tamanioEsperado, tamanioObtenido);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaPuedoAgregarUnProductoBebidaDeTipoJugoTamanioGrandeYCuandoConsultoPorLasBebidasObtengoUnaDeTipoJugoTamanioGrande() {
		Bebida jugo = new Bebida();
		jugo.setTamanio(Tamanio.GRANDE);
		jugo.setTipoBebida(TipoBebida.JUGO);
		this.hamburgueseria.agregarProducto(jugo);

		Tamanio tamanioEsperado = Tamanio.GRANDE;
		TipoBebida tipoBebidaEsperado = TipoBebida.JUGO;
		TipoBebida tipoBebidaObtenido = jugo.getTipoBebida();

		assertEquals(tamanioEsperado, jugo.getTamanio());
		assertEquals(tipoBebidaEsperado, tipoBebidaObtenido);

	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaPuedoAgregarUnProductoBebidaDeTipoJugoTamanioGrandeYCuandoConsultoSuPrecioObtengoCuatroMil() {
		Bebida jugo = new Bebida();
		jugo.setTamanio(Tamanio.GRANDE);
		jugo.setTipoBebida(TipoBebida.JUGO);
		this.hamburgueseria.agregarProducto(jugo);

		Double precioEsperado = 4000.0;
		Double precioObtenido = jugo.obtenerPrecio();

		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaPuedoAgregarUnProductoBebidaDeTipoCervezaTamanioGrandeYCuandoConsultoSuPrecioObtengoSeisMil() {
		Bebida cerveza = new Bebida();
		cerveza.setTamanio(Tamanio.GRANDE);
		cerveza.setTipoBebida(TipoBebida.CERVEZA);
		this.hamburgueseria.agregarProducto(cerveza);


		Double precioEsperado = 6000.0;
		Double precioObtenido = cerveza.obtenerPrecio();

		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaPuedoAgregarUnProductoBebidaDeTipoCervezaTamanioGrandeYUnProductoAguaTamanioChicoYCuandoConsultoSuPrecioObtengoOchoMil() {
		Bebida cerveza = new Bebida();
		cerveza.setTamanio(Tamanio.GRANDE);
		cerveza.setTipoBebida(TipoBebida.CERVEZA);
		this.hamburgueseria.agregarProducto(cerveza);

		Bebida agua = new Bebida();
		agua.setTamanio(Tamanio.CHICA);
		agua.setTipoBebida(TipoBebida.AGUA);
		this.hamburgueseria.agregarProducto(agua);


		
		Double precioEsperado = 8000.0;
		Double precioObtenido = (cerveza.obtenerPrecio() + agua.obtenerPrecio());

		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void dadoQueExisteUnaHamburgueseriaPuedoAgregarUnCliente() {
		Cliente cliente = new Cliente("Juan");

		Boolean agregado = this.hamburgueseria.agregarCliente(cliente);

		assertTrue(agregado);
	}
	
	@Test
	public void dadoQueExisteUnaHamburgueseriaConUnClientePuedoHacerQueElClienteHagaUnPedidoQueContengaUnAguaChicaYUnaHamburguesaSimple() {
		Cliente cliente = new Cliente("Juan");
		this.hamburgueseria.agregarCliente(cliente);
		
		Bebida agua = new Bebida();
		agua.setTamanio(Tamanio.CHICA);
		agua.setTipoBebida(TipoBebida.AGUA);
		
		Producto hamburguesa = new Hamburguesa();
		hamburguesa.setNombre("Simple");
		
		List<Producto> listaDeProductosParaElPedido = new ArrayList<>();
		listaDeProductosParaElPedido.add(agua);
		listaDeProductosParaElPedido.add(hamburguesa);
		
		hamburgueseria.crearPedidoParaCLiente(cliente, listaDeProductosParaElPedido);


		List<Pedido> pedidosDelCliente = cliente.getPedidos();
		int cantidadDePedidosDelClienteEsperados = 1;
		
		Pedido pedido = pedidosDelCliente.get(0);
		
		List<Producto> productosEnElPedido = pedido.getProductos();
		int cantidadDeProductosEnElPedidoEsperados = 2;
		
		
		assertEquals(cantidadDePedidosDelClienteEsperados, pedidosDelCliente.size());
		assertEquals(cantidadDeProductosEnElPedidoEsperados, productosEnElPedido.size());
		
		assertTrue(productosEnElPedido.contains(agua));
		assertTrue(productosEnElPedido.contains(hamburguesa));


	}
}
