# -*- coding: utf8 -*-

from tornado.web import Application

from orator import DatabaseManager, Model

from .orator import DATABASES
from .settings import settings
from .urls import url_patterns

class ApiService(Application):
    def __init__(self):
        db = DatabaseManager(DATABASES)
        Model.set_connection_resolver(db)

        Application.__init__(self, url_patterns, **settings)