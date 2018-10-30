function validate_user()
      {
      
         if( document.myForm.larp_title.value == "" )
         {
            alert( "Please providelarp title!" );
            document.myForm.larp_title.focus() ;
            return false;
         }
         
         if( document.myForm.larp_descr.value == "" )
         {
            alert( "Please provide larp description!" );
            document.myForm.larp_descr.focus() ;
            return false;
         }
         
         if( document.myForm.larp_place.value == "" )
         {
            alert( "Please provide larp place!" );
            document.myForm.larp_place.focus() ;
            return false;
         }
         
         if( document.myForm.larp_authors.value == "" )
         {
            alert( "Please provide larp authors!" );
            document.myForm.larp_authors.focus() ;
            return false;
         }
         
         if ( isNaN( document.myForm.larp_cur_partic.value ))
         {
            alert( "Please enter current no of participants in a number form" );
            document.myForm.larp_cur_partic.focus();
            return false;
         }
         
         if ( document.myForm.larp_cur_partic.value <= 0)
         {
            alert( "Please enter a positive number. The field cannot be empty" );
            document.myForm.larp_cur_partic.focus();
            return false;
         }
         
         if ( isNaN( document.myForm.larp_max_partic.value ))
         {
            alert( "Please enter max no of participants in a number form" );
            document.myForm.larp_max_partic.focus();
            return false;
         }
         
         if ( document.myForm.larp_max_partic.value <= 0)
         {
            alert( "Please enter a positive number. The field cannot be empty" );
            document.myForm.larp_max_partic.focus();
            return false;
         }
         
         return( true );}