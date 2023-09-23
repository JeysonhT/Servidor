import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Casa de repuesto'),
        ),
        body: AffiliatesList(),
      ),
    );
  }
}

class AffiliatesList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final AffiliatesProvider provider = AffiliatesProvider();

    return ListView.builder(
      itemCount: provider.getAffiliates().length,
      itemBuilder: (context, index) {
        final affiliate = provider.getAffiliates()[index];
        return ListTile(
          title: Text(
              'Nombre de la casa de repuesto: ${affiliate.nombrecasarepueto} '),
          subtitle: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text('Contacto: ${affiliate.contacto}'),
              Text('Ubicacion: ${affiliate.ubicacion}'),
              Text('Horario: ${affiliate.horario}'),
              Text('Especioalidad: ${affiliate.especialidad}'),
            ],
          ),
        );
      },
    );
  }
}

class Affiliate {
  final String nombrecasarepueto;
  final String ubicacion;
  final String contacto;

  final String horario;
  final String especialidad;

  Affiliate({
    required this.nombrecasarepueto, //
    required this.ubicacion,
    required this.contacto,
    required this.horario,
    required this.especialidad,
  });
}

class AffiliatesProvider {
  final List<Affiliate> affiliates = [
    Affiliate(
      nombrecasarepueto: 'Juan',
      ubicacion: 'managua',
      contacto: '88888888',
      horario: '8AM-6PM',
      especialidad: 'carro',
    ),
    Affiliate(
      nombrecasarepueto: 'María',
      ubicacion: 'juigalpa',
      contacto: '888888888',
      horario: '8AM-6PM',
      especialidad: 'moto',
    ),
    // Agrega más afiliados con sus detalles aquí
  ];

  List<Affiliate> getAffiliates() {
    return affiliates;
  }
}
