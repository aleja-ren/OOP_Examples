@Test 
public void testNombreColeccion(){
	Coleccion coleccion = new Coleccion("Cromos");
	//se pone assertEquals(actual, expected)
	assertEquals(coleccion.getNombre(), "Cromos");
}

@Test (expected = IllegalArgumentException.class)
public void testNombreIncorrecto(){
	Coleccion coleccionIncorrecta = new Coleccion("");
}

@Test
public void testEmpresa(){
	Empresa empresaNueva = new Empresa(String "presidente", String "cif", int 47001, ArrayList<Negocios> negocios);
	assertNotNull(empresaNueva);
}

@Test (expected = IllegalArgumentException.class)
public void testEmpresaPresidenteNulo(){
	Empresa empresaNueva = new Empresa(String null, String "cif", int 47001, ArrayList<Negocios> negocios);
}
