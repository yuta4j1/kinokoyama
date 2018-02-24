/**
 * モーダルウィンドウの表示スクリプト
 */
$(function() {
  $('#modal-addUser-open').on('click', function() {
    $('#addUser-content').after('<div id="overlay"></div>');
    $('#overlay, #modal-addUser').fadeIn();
  });

  $('#close').on('click', function() {
    $('#overlay, #modal-addUser').fadeOut();
  });

  locateCenter();
  $(window).resize(locateCenter);

  function locateCenter() {
    let w = $(window).width();
    let h = $(window).height();

    let cw = $('#modal-addUser').outerWidth();
    let ch = $('#modal-addUser').outerHeight();

    $('#modal-addUser').css({
      'left' : ((w - cw) / 2) + 'px',
      'top' : ((h - ch) / 2) + 'px'
    });
  }
});


