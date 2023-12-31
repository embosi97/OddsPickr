import 'package:oddspickrfrontend/odds_object.dart';

class TeamEntity {
  
  const TeamEntity({required this.eventId, required this.sportName, required this.homeTeam, required this.awayTeam, required this.eventTime, required this.oddsMap});

  final String eventId;

  final String sportName;

  final String homeTeam;

  final String awayTeam;

  final String eventTime;

  final Map<String, dynamic> oddsMap;

  factory TeamEntity.fromJson(dynamic json) {

    Map<String, dynamic> oddsObjectMap = {};

    (json['oddsMap'] as Map).forEach((key, value) {
        oddsObjectMap[key] = OddsObject(homeOdds: value['homeOdds'], awayOdds: value['awayOdds']);
    });

    return TeamEntity(
        eventId: json['eventId'],
        sportName: json['sportName'],
        homeTeam: json['homeTeam'],
        awayTeam: json['awayTeam'],
        eventTime: json['eventTime'],
        oddsMap: oddsObjectMap);
  }
}
