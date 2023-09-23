import 'package:flutter/material.dart';

void main() {
  runApp(Registro());
}

class Client {
  String nombres;
  String apellidos;
  String telefono;
  String correoElectronico;
  String ubicacion;
  String cedula;

  Client({
    required this.nombres,
    required this.apellidos,
    required this.telefono,
    required this.correoElectronico,
    required this.ubicacion,
    required this.cedula,
  });
}

class Registro extends StatefulWidget {
  Registro({Key? key}) : super(key: key);

  @override
  _RegistroState createState() => _RegistroState();
}

class _RegistroState extends State<Registro> {
  final TextEditingController nombresController = TextEditingController();
  final TextEditingController apellidosController = TextEditingController();
  final TextEditingController telefonoController = TextEditingController();
  final TextEditingController correoController = TextEditingController();
  final TextEditingController ubicacionController = TextEditingController();
  final TextEditingController cedulaController = TextEditingController();

  final List<Client> clients = [];

  void registerClient() {
    final client = Client(
      nombres: nombresController.text,
      apellidos: apellidosController.text,
      telefono: telefonoController.text,
      correoElectronico: correoController.text,
      ubicacion: ubicacionController.text,
      cedula: cedulaController.text,
    );

    setState(() {
      clients.add(client);
    });

    // Aquí puedes realizar acciones adicionales, como guardar en una base de datos.

    // Limpiar los campos del formulario después de registrar.
    nombresController.clear();
    apellidosController.clear();
    telefonoController.clear();
    correoController.clear();
    ubicacionController.clear();
    cedulaController.clear();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Inicio de Sesion'),
        ),
        body: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              const Text('Correo Electronico '),
              TextField(controller: nombresController),
              const SizedBox(height: 10),
              const Text('Contraseña'),
              TextField(controller: apellidosController),
              const SizedBox(height: 10),
              ElevatedButton(
                onPressed: registerClient,
                child: const Text('Inicio de sesion'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
