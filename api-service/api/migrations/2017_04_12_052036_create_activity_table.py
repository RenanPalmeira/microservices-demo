from orator.migrations import Migration


class CreateActivityTable(Migration):

    def up(self):
        """
        Run the migrations.
        """
        with self.schema.create('activity') as table:
            table.increments('id_activity')
            table.string('name', 255)
            table.string('category', 255)
            table.string('tag', 255)
            table.timestamps()

        self.db.table('activity').insert([
            {'name': 'install orator', 'category': 'computer', 'tag': 'php'},
        ])

    def down(self):
        """
        Revert the migrations.
        """
        pass
