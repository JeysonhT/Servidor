import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text('Lista de talleres mecanicos'),
        ),
        body: Afliliadotaller(),
      ),
    );
  }
}

class Afliliadotaller extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final AffiliatesProvider provider = AffiliatesProvider();

    return ListView.builder(
      itemCount: provider.getAffiliates().length,
      itemBuilder: (context, index) {
        final affiliate = provider.getAffiliates()[index];
        return ListTile(
          title: Text('Nombre del taller: ${affiliate.nombretaller} '),
          subtitle: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text('Nombre del jefe de mecanico: ${affiliate.nombreUsuario}'),
              Text('Ubicación: ${affiliate.Ubicacion}'),
              Text('Especialidad: ${affiliate.Especialidad}'),
              Text('Horario de atencion: ${affiliate.horario}'),
            ],
          ),
        );
      },
    );
  }
}

class Affiliate {
  final String nombretaller;

  final String nombreUsuario;
  final String Ubicacion;
  final String Especialidad;
  final String horario;

  Affiliate({
    required this.nombretaller, //
    required this.nombreUsuario,
    required this.Ubicacion,
    required this.Especialidad,
    required this.horario,
  });
}

class AffiliatesProvider {
  final List<Affiliate> affiliates = [
    Affiliate(
      nombretaller: 'Juan',
      nombreUsuario: 'juangomez',
      Ubicacion: 'Ciudad A',
      Especialidad: 'moto',
      horario: '7AM-6PM',
    ),
    Affiliate(
      nombretaller: 'María',
      nombreUsuario: 'marialopez',
      Ubicacion: 'Ciudad B',
      Especialidad: 'Carro',
      horario: '8AM-7PM',
    ),
    // Agrega más afiliados con sus detalles aquí
  ];

  List<Affiliate> getAffiliates() {
    return affiliates;
  }
}
