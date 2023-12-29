import 'package:flutter/material.dart';
import 'package:oddspickrfrontend/EntityList.dart';
import 'package:oddspickrfrontend/httpservice_get.dart';
import 'package:oddspickrfrontend/team_entity.dart';


void main() {
  runApp(MyHomePage());
}

// ignore: must_be_immutable
class MyHomePage extends StatelessWidget {

  // ignore: prefer_typing_uninitialized_variables
  final title;

  HttpService httpService = HttpService();

  // ignore: use_key_in_widget_constructors
  MyHomePage({this.title});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Stack(children: <Widget>[
      Container(
        padding: const EdgeInsets.all(15),
        width: MediaQuery.of(context).size.width,
        color: Colors.black,
        child: SafeArea(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: <Widget>[
              Row(
                children: <Widget>[
                  const Expanded(
                    flex: 1,
                    child: Text(
                      "Event Watch List",
                      style: TextStyle(
                          color: Colors.white,
                          fontSize: 30,
                          fontWeight: FontWeight.bold),
                    ),
                  ),
                  Expanded(
                    flex: 1,
                    child: Text(
                      DateTime.now().toString(),
                      textAlign: TextAlign.right,
                      style: TextStyle(
                          color: Colors.grey[500],
                          fontSize: 24,
                          fontWeight: FontWeight.bold),
                    ),
                  ),
                ],
              ),
              Column(
                crossAxisAlignment: CrossAxisAlignment.stretch,
                children: [
                  Text(
                   DateTime.now().toString(),
                    textAlign: TextAlign.right,
                    style: TextStyle(
                        color: Colors.grey[500],
                        fontSize: 24,
                        fontWeight: FontWeight.bold),
                  ),
                ],
              ),
              Padding(
                padding: const EdgeInsets.only(top: 15),
                child: FutureBuilder(
                  future: httpService.getEntities(),
                  builder: (BuildContext context,
                      AsyncSnapshot<List<TeamEntity>> snapshot) {
                    if (snapshot.hasData) {
                      List<TeamEntity> entityList = snapshot.requireData;
                      return SizedBox(
                          height: MediaQuery.of(context).size.height - 310,
                          child: EntityList(
                            entities: entityList,
                          ));
                    } else {
                      return const Center(child: CircularProgressIndicator());
                    }
                  },
                ),
              )
            ],
          ),
        ),
      )
    ]));
  }
}