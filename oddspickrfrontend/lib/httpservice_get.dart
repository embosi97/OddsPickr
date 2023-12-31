import 'dart:convert';
import 'package:http/http.dart';
import 'package:oddspickrfrontend/team_entity.dart';

class HttpService {

  final String entityURL = "http://localhost:8080/upcoming/us/epl";

  Future<List<TeamEntity>> getEntities() async {
  
  Response res = await get(Uri.parse(entityURL));

  if (res.statusCode == 200) {

    final obj = jsonDecode(res.body);

    final data = <TeamEntity>[];
    
    for(final x in obj){
      try{

        final team = TeamEntity.fromJson(x);
        data.add(team);
      }catch (e){
        print('$e');
      }
    }
    return data;
  } else {
    throw "Unable to retrieve stock data.";
  }
}
}