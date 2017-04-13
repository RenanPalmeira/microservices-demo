#!/usr/bin/env python
# -*- coding: utf8 -*-

import fire

import tornado.httpserver
import tornado.ioloop

from api.app import ApiService

class Command:
    port = 8081

    def runserver(self):
        print('* Server listen in http://localhost:' + str(self.port))
        app = ApiService()
        http_server = tornado.httpserver.HTTPServer(app)
        http_server.listen(self.port)
        tornado.ioloop.IOLoop.instance().start()

if __name__ == '__main__':
  fire.Fire(Command)