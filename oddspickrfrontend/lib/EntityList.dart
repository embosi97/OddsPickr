// ignore_for_file: file_names

import 'package:flutter/material.dart';
import 'package:oddspickrfrontend/team_entity.dart';

class EntityList extends StatelessWidget {

    final List<TeamEntity> entities;

    // ignore: use_key_in_widget_constructors
    const EntityList({required this.entities});

    @override
    Widget build(BuildContext context) {
         return Scaffold(
          body: ListView.separated(
                separatorBuilder: (context, index) {
            return const Divider(color: Color.fromARGB(255, 104, 103, 103));
        },
        itemCount: entities.length,
                itemBuilder: (context, index) {
                  
            final event = entities[index];
    
            return ListTile(
                    contentPadding: const EdgeInsets.all(10),
                    title: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
            Text("${event.homeTeam} vs ${event.awayTeam}",
                    style: const TextStyle(
                    color: Colors.black,
                    fontSize: 24,
                    fontWeight: FontWeight.w500)),
            Text("Upcoming",
                    style: const TextStyle(color: Colors.black, fontSize: 20))
              ]),
            trailing: Column(
                    crossAxisAlignment: CrossAxisAlignment.end,
                    children: <Widget>[
            Text(
                    event.eventTime,
                    style: const TextStyle(
                    color: Colors.black,
                    fontSize: 24,
                    fontWeight: FontWeight.w500),
              ),
            Container(
                    alignment: Alignment.center,
                    width: 75,
                    height: 20,
                    decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(5),
                    color: Colors.black),
            child: const Text(
                    "Upcoming",
                    style: TextStyle(
                    color: Colors.black,
                    fontSize: 15,
                  ),
                ),
              )
            ],
          ),
        );
        },
    )
         );
    }
}