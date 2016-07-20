(function($) {
    $(function() {
        $('input.cq-auto-clear').each(function() {
            var def = this.value;
            this.onfocus = function() {
                if (this.value == def) {
                    this.value = "";
                }
            };
            this.onblur = function() {
                if (this.value == "") {
                    this.value = def;
                }
            };
        });

        $('#topnav').each(function() {

            function getSubnav(ele) {
                if (ele.nodeName.toLowerCase() == 'li') {
                    var subnav = $('> ul', ele);
                    return subnav.length ? subnav[0] : null;
                } else {
                    return ele;
                }
            }

            function hide() {
                var subnav = getSubnav(this);
                if (subnav) {
                    $(subnav).hide();
                }
            }

            function show() {
                var subnav = getSubnav(this);
                if (subnav) {
                    $(subnav).show();
                }
            }

            $('ul, li', this).hover(show, hide);
            $('li', this).hover(
                    function() {
                        $(this).addClass('hover');
                    },
                    function() {
                        $(this).removeClass('hover');
                    }
                    );
        });

    });
})($);