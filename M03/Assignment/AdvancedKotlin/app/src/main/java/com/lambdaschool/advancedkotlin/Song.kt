package com.lambdaschool.advancedkotlin

sealed class Song (val name: String, val artist: String)

class RBHipHop (name: String, artist: String): Song(name, artist)
class Pop (name: String, artist: String): Song(name, artist)
class Country (name: String, artist: String): Song(name, artist)
class Rock (name: String, artist: String): Song(name, artist)
class Dance (name: String, artist: String): Song(name, artist)
