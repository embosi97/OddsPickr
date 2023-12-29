import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart';
import 'package:oddspickrfrontend/team_entity.dart';

class HttpService {

  final String entityURL = "http://localhost:8080/upcoming/us/epl";

  Future<List<TeamEntity>> getEntities() async {

    Response res = await get(Uri.parse(entityURL));

    if (res.statusCode == 200) {
      
      final obj = jsonDecode(res.body);

      debugPrint(obj.toString());
  
      return (obj as List).map((p) => TeamEntity.fromJson(p)).toList();

    } else {

      throw "Unable to retrieve stock data.";

    }
  }
}