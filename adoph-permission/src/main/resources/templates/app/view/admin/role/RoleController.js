/**
 * 角色管理Controller
 */
Ext.define('Framework.view.admin.role.RoleController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.role',
    control: {
        'grid': {
            afterrender: 'onGridAfterrender'
        }
    },

    //首次加载
    onGridAfterrender: function (grid, eOpts) {
        var me = this;
        var store = grid.getStore();
        store.on('beforeload', function (store, options) {
            var grid = Ext.ComponentQuery.query('role-grid')[0];
            var form = grid.lookupReference('queryForm');
            var params = me.getQueryParams(form);
            Ext.apply(store.proxy.extraParams, params);
        });
        store.load();
    },

    //获取查询参数
    getQueryParams: function (form) {
        var values = form.getValues();
        return {
            roleName: values.roleName || null
        }
    },

    //查询
    queryRole: function () {
        var grid = this.lookup('roleGrid');
        var form = this.lookup('queryForm');
        var params = this.getQueryParams(form);
        grid.getStore().reload({
            params: params
        });
    },

    //添加
    add: function () {
        Ext.require('Framework.view.admin.role.EditRole', function () {
            Ext.create({
                xtype: 'edit-role',
                title: '新增角色'
            }).show();
        });
    },

    //编辑
    edit: function () {
        var me = this,
            grid = me.lookupReference('roleGrid'),
            row = grid.getSelection()[0];
        if (row) {
            Ext.require('Framework.view.admin.role.EditRole', function () {
                var editUserWin = Ext.create({
                    xtype: 'edit-role',
                    title: '编辑角色'
                });
                editUserWin.show();
                var form = editUserWin.lookup('editRoleForm');
                form.loadRecord(row);
            });
        } else {
            Ext.Msg.show({
                title: '系统提示',
                message: '请选择一条数据！',
                buttons: Ext.Msg.OK,
                icon: Ext.Msg.INFO
            });
        }
    },

    //删除
    del: function () {
        var me = this,
            grid = me.lookupReference('roleGrid'),
            row = grid.getSelection()[0];
        if (row) {
            Ext.Msg.show({
                title: '系统提示',
                message: '确定删除此条数据！',
                buttons: Ext.Msg.OKCANCEL,
                icon: Ext.Msg.QUESTION,
                closable: false,
                fn: function (btn) {
                    if (btn === 'ok') {
                        var logoutMask = new Ext.LoadMask({
                            msg: '正在删除数据...',
                            target: Ext.ComponentQuery.query('app-main')[0]
                        });
                        logoutMask.show();
                        Ext.Ajax.request({
                            url: 'sysRole/del.do',
                            params: {
                                id: row.data.id
                            },
                            success: function (response) {
                                logoutMask.hide();
                                var r = Ext.decode(response.responseText);
                                if (r.success === true) {
                                    grid.getStore().reload({page: 1, start: 0});
                                    Ext.toast({
                                        title: '系统提示',
                                        html: '删除成功！',
                                        closable: false,
                                        align: 't',
                                        slideInDuration: 400,
                                        minWidth: 350,
                                        iconCls: 'right-icon',
                                        autoCloseDelay: 2500
                                    });
                                } else {
                                    Ext.Msg.show({
                                        title: '系统提示',
                                        message: r.msg,
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.Msg.ERROR
                                    });
                                }
                            }
                        });
                    }
                }
            });
        } else {
            Ext.Msg.show({
                title: '系统提示',
                message: '请选择一条数据！',
                buttons: Ext.Msg.OK,
                icon: Ext.Msg.INFO
            });
        }
    }
});