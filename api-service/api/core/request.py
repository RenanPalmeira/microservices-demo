# -*- coding: utf8 -*-

from tornado.web import RequestHandler

class APIHandler(RequestHandler):
    """RequestHandler for API calls
    - Sets header as ``application/json``
    - Provides custom write_error that writes error back as JSON \
    rather than as the standard HTML template
    """

    def initialize(self):
        """
        - Set Content-type for JSON
        """
        self.set_header("Content-Type", "application/json")