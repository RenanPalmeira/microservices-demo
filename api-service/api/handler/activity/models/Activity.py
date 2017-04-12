# -*- coding: utf8 -*-

from orator import Model

class Activity(Model):
    __primary_key__ = 'id_activity'
    __table__ = 'activity'