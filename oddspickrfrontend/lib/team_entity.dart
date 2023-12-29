import 'package:oddspickrfrontend/odds_object.dart';

class TeamEntity {
  
  const TeamEntity({required this.eventId, required this.sportName, required this.homeTeam, required this.awayTeam, required this.eventTime, required this.oddsMap});

  final String eventId;

  final String sportName;

  final String homeTeam;

  final String awayTeam;

  final String eventTime;

  final Map<String, OddsObject> oddsMap;

  factory TeamEntity.fromJson(Map<String, dynamic> json) {
    return TeamEntity(
        eventId: json['eventId'],
        sportName: json['sportName'],
        homeTeam: json['homeTeam'],
        awayTeam: json['awayTeam'],
        eventTime: json['eventTime'],
        oddsMap: json['oddsMap']);
  }
}
