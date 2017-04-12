#!/usr/bin/env python
# -*- coding: utf8 -*-

import fire

import tornado.httpserver
import tornado.ioloop

from api.app import ApiService

class Command:
    def runserver(self):
        print('* Server listen in http://localhost:8080')
        app = ApiService()
        http_server = tornado.httpserver.HTTPServer(app)
        http_server.listen(8080)
        tornado.ioloop.IOLoop.instance().start()

if __name__ == '__main__':
  fire.Fire(Command)