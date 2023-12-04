/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package de.schoenbeck.serverprint.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for sbsp_printerprovider
 *  @author iDempiere (generated) 
 *  @version Release 10
 */
@SuppressWarnings("all")
public interface I_sbsp_printerprovider 
{

    /** TableName=sbsp_printerprovider */
    public static final String Table_Name = "sbsp_printerprovider";

    /** AD_Table_ID=1000015 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

    /** Column name AD_Process_ID_Printing */
    public static final String COLUMNNAME_AD_Process_ID_Printing = "AD_Process_ID_Printing";

	/** Set Printing Implementation	  */
	public void setAD_Process_ID_Printing (int AD_Process_ID_Printing);

	/** Get Printing Implementation	  */
	public int getAD_Process_ID_Printing();

	public org.compiere.model.I_AD_Process getAD_Process_ID_Print() throws RuntimeException;

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name Help */
    public static final String COLUMNNAME_Help = "Help";

	/** Set Comment/Help.
	  * Comment or Hint
	  */
	public void setHelp (String Help);

	/** Get Comment/Help.
	  * Comment or Hint
	  */
	public String getHelp();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();

    /** Column name lookup_printers */
    public static final String COLUMNNAME_lookup_printers = "lookup_printers";

	/** Set Lookup Printers.
	  * Lookup the printers behind this provider
	  */
	public void setlookup_printers (String lookup_printers);

	/** Get Lookup Printers.
	  * Lookup the printers behind this provider
	  */
	public String getlookup_printers();

    /** Column name printer_password */
    public static final String COLUMNNAME_printer_password = "printer_password";

	/** Set printer password	  */
	public void setprinter_password (String printer_password);

	/** Get printer password	  */
	public String getprinter_password();

    /** Column name printer_uri */
    public static final String COLUMNNAME_printer_uri = "printer_uri";

	/** Set printer URI	  */
	public void setprinter_uri (String printer_uri);

	/** Get printer URI	  */
	public String getprinter_uri();

    /** Column name printer_username */
    public static final String COLUMNNAME_printer_username = "printer_username";

	/** Set printer username	  */
	public void setprinter_username (String printer_username);

	/** Get printer username	  */
	public String getprinter_username();

    /** Column name sbsp_printerprovider_ID */
    public static final String COLUMNNAME_sbsp_printerprovider_ID = "sbsp_printerprovider_ID";

	/** Set Printer Provider	  */
	public void setsbsp_printerprovider_ID (int sbsp_printerprovider_ID);

	/** Get Printer Provider	  */
	public int getsbsp_printerprovider_ID();

    /** Column name sbsp_printerprovider_UU */
    public static final String COLUMNNAME_sbsp_printerprovider_UU = "sbsp_printerprovider_UU";

	/** Set sbsp_printerprovider_UU	  */
	public void setsbsp_printerprovider_UU (String sbsp_printerprovider_UU);

	/** Get sbsp_printerprovider_UU	  */
	public String getsbsp_printerprovider_UU();
}
