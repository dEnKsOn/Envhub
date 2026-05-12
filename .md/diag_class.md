<?xml version="1.0" encoding="windows-1252" standalone="no" ?>
<Package name="diag_classe" guid="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}">
	<Table name="t_package">
		<Row>
			<Column name="Package_ID" value="2"/>
			<Column name="Name" value="diag_classe"/>
			<Column name="Parent_ID" value="1"/>
			<Column name="CreatedDate" value="2026-04-22 23:55:06"/>
			<Column name="ModifiedDate" value="2026-04-22 23:55:06"/>
			<Column name="ea_guid" value="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
			<Column name="IsControlled" value="0"/>
			<Column name="Version" value="1.0"/>
			<Column name="Protected" value="0"/>
			<Column name="UseDTD" value="0"/>
			<Column name="LogXML" value="0"/>
			<Column name="PackageFlags" value="isModel=1;VICON=3;"/>
			<Extension/>
		</Row>
		<Row>
			<Column name="Package_ID" value="4"/>
			<Column name="Name" value="DDL"/>
			<Column name="Parent_ID" value="2"/>
			<Column name="CreatedDate" value="2026-04-26 01:33:37"/>
			<Column name="ModifiedDate" value="2026-04-26 01:33:37"/>
			<Column name="ea_guid" value="{5B186279-D6A5-4612-A233-2C55FD32D359}"/>
			<Column name="IsControlled" value="0"/>
			<Column name="Version" value="1.0"/>
			<Column name="Protected" value="0"/>
			<Column name="UseDTD" value="0"/>
			<Column name="LogXML" value="0"/>
			<Column name="Namespace" value="1"/>
			<Extension Parent_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
	</Table>
	<Table name="t_object">
		<Row>
			<Column name="Object_ID" value="35"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Profil"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="4"/>
			<Column name="Stereotype" value="table"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-26 01:33:37"/>
			<Column name="ModifiedDate" value="2026-04-26 01:33:37"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA2" value="MySql"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="MySql"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{0253C706-2C51-42d9-A611-3F09FA19C5C0}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{5B186279-D6A5-4612-A233-2C55FD32D359}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="11"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Environnement"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="17"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-23 00:17:47"/>
			<Column name="ModifiedDate" value="2026-04-26 01:04:47"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="Java"/>
			<Column name="GenFile" value="C:\users\jub-ubuntu\Videos\PROJET_STAGE_NEW_DEV\New Folder\Environnement.java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{1C8F4B2F-BAB5-4328-9F44-F9CA3721015D}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="37"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Serveur"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="4"/>
			<Column name="Stereotype" value="table"/>
			<Column name="NType" value="17"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-26 01:33:37"/>
			<Column name="ModifiedDate" value="2026-04-26 01:33:37"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA2" value="MySql"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="MySql"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{2097F4D6-2054-4096-A530-4B473039D622}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{5B186279-D6A5-4612-A233-2C55FD32D359}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="4"/>
			<Column name="Object_Type" value="Enumeration"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="TypeEnvironnement"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-22 23:59:19"/>
			<Column name="ModifiedDate" value="2026-04-26 01:04:49"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="GenType" value="Java"/>
			<Column name="GenFile" value="C:\users\jub-ubuntu\Videos\PROJET_STAGE_NEW_DEV\New Folder\TypeEnvironnement.java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{27A8DAE9-616D-4564-AA2E-32FB0344CCB2}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="34"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Environnement"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="4"/>
			<Column name="Stereotype" value="table"/>
			<Column name="NType" value="17"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-26 01:33:37"/>
			<Column name="ModifiedDate" value="2026-04-26 01:33:37"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA2" value="MySql"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="MySql"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{5B186279-D6A5-4612-A233-2C55FD32D359}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="9"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Profil"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-23 00:13:56"/>
			<Column name="ModifiedDate" value="2026-04-26 01:04:47"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="Java"/>
			<Column name="GenFile" value="C:\users\jub-ubuntu\Videos\PROJET_STAGE_NEW_DEV\New Folder\Profil.java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{3DE948F4-C3A6-46d9-B8AD-C94607E24D09}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="1"/>
			<Column name="Object_Type" value="Package"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="diag_classe"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="1"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-22 23:55:06"/>
			<Column name="ModifiedDate" value="2026-04-22 23:55:06"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA1" value="2"/>
			<Column name="GenType" value="Java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension PDATA1="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="36"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Projet"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="4"/>
			<Column name="Stereotype" value="table"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-26 01:33:37"/>
			<Column name="ModifiedDate" value="2026-04-26 01:33:37"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA2" value="MySql"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="MySql"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{5B186279-D6A5-4612-A233-2C55FD32D359}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="44"/>
			<Column name="Object_Type" value="Enumeration"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="RoleProjet"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-27 13:15:49"/>
			<Column name="ModifiedDate" value="2026-04-27 13:16:04"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="GenType" value="Java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{583F726F-3BD9-4c63-BE4D-8C75344A2D45}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="33"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Client"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="4"/>
			<Column name="Stereotype" value="table"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-26 01:33:37"/>
			<Column name="ModifiedDate" value="2026-04-26 01:33:37"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA2" value="MySql"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="MySql"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{58A3CC04-A720-407d-81DC-DB30D3247A09}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{5B186279-D6A5-4612-A233-2C55FD32D359}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="31"/>
			<Column name="Object_Type" value="Package"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="DDL"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-26 01:33:37"/>
			<Column name="ModifiedDate" value="2026-04-26 01:33:37"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA1" value="4"/>
			<Column name="GenType" value="Java"/>
			<Column name="GenFile" value="C:\users\jub-ubuntu\Videos\PROJET_STAGE_NEW_DEV\New Folder\creation_table.sql"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{5B186279-D6A5-4612-A233-2C55FD32D359}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}" PDATA1="{5B186279-D6A5-4612-A233-2C55FD32D359}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="39"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Utilisateur"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="4"/>
			<Column name="Stereotype" value="table"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-26 01:33:37"/>
			<Column name="ModifiedDate" value="2026-04-26 01:33:37"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA2" value="MySql"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="MySql"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{5B186279-D6A5-4612-A233-2C55FD32D359}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="2"/>
			<Column name="Object_Type" value="Enumeration"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="StatutProjet"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-22 23:56:39"/>
			<Column name="ModifiedDate" value="2026-04-26 01:04:49"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="GenType" value="Java"/>
			<Column name="GenFile" value="C:\users\jub-ubuntu\Videos\PROJET_STAGE_NEW_DEV\New Folder\StatutProjet.java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{666B04EE-1C5C-4438-B2AD-8DC7274ECADA}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="12"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Technologie"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="17"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-23 00:20:04"/>
			<Column name="ModifiedDate" value="2026-04-26 01:04:49"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="Java"/>
			<Column name="GenFile" value="C:\users\jub-ubuntu\Videos\PROJET_STAGE_NEW_DEV\New Folder\Technologie.java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{74933CA6-06EB-4103-B908-1B97053678E9}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="5"/>
			<Column name="Object_Type" value="Enumeration"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="TypeTechno"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-23 00:00:04"/>
			<Column name="ModifiedDate" value="2026-04-26 01:04:50"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="GenType" value="Java"/>
			<Column name="GenFile" value="C:\users\jub-ubuntu\Videos\PROJET_STAGE_NEW_DEV\New Folder\TypeTechno.java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{8C149F02-5496-4a6d-8BD2-67DD97909651}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="38"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Technologie"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="4"/>
			<Column name="Stereotype" value="table"/>
			<Column name="NType" value="17"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-26 01:33:37"/>
			<Column name="ModifiedDate" value="2026-04-26 01:33:37"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA2" value="MySql"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="MySql"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{930F4F1D-C6CA-4ee9-A1C3-F7A85CC03D63}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{5B186279-D6A5-4612-A233-2C55FD32D359}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="8"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Utilisateur"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-23 00:05:09"/>
			<Column name="ModifiedDate" value="2026-04-26 01:04:50"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="Java"/>
			<Column name="GenFile" value="C:\users\jub-ubuntu\Videos\PROJET_STAGE_NEW_DEV\New Folder\Utilisateur.java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{9C36619A-26FA-49f9-8ECE-B23BEAB870CC}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="20"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="VersionTechno"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="17"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-23 00:32:41"/>
			<Column name="ModifiedDate" value="2026-04-26 01:04:51"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA4" value="9"/>
			<Column name="GenType" value="Java"/>
			<Column name="GenFile" value="C:\users\jub-ubuntu\Videos\PROJET_STAGE_NEW_DEV\New Folder\VersionTechno.java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{9E44FF21-E97C-4393-B87A-660FBF7BFA60}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}" PDATA4="{AECC08A9-44FB-4abd-8BB3-81A0A6FF3637}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="6"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Projet"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-23 00:01:19"/>
			<Column name="ModifiedDate" value="2026-04-26 01:04:48"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="Java"/>
			<Column name="GenFile" value="C:\users\jub-ubuntu\Videos\PROJET_STAGE_NEW_DEV\New Folder\Projet.java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{A02A9B57-1644-4ac6-9CF0-CA35B54DBA0E}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="7"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Client"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="0"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-23 00:04:20"/>
			<Column name="ModifiedDate" value="2026-04-26 01:04:43"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="Java"/>
			<Column name="GenFile" value="C:\users\jub-ubuntu\Videos\PROJET_STAGE_NEW_DEV\New Folder\Client.java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{A7B42C3B-9BA7-444a-9164-53DF80D177BF}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="40"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Versiontechno"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="4"/>
			<Column name="Stereotype" value="table"/>
			<Column name="NType" value="17"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-26 01:33:37"/>
			<Column name="ModifiedDate" value="2026-04-26 01:33:37"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA2" value="MySql"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="MySql"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{5B186279-D6A5-4612-A233-2C55FD32D359}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="14"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Serveur"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="17"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-23 00:22:00"/>
			<Column name="ModifiedDate" value="2026-04-26 01:04:48"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="Java"/>
			<Column name="GenFile" value="C:\users\jub-ubuntu\Videos\PROJET_STAGE_NEW_DEV\New Folder\Serveur.java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{C2AC65EB-1D25-4d3e-859F-C48D308DB514}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="32"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Affectation"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="4"/>
			<Column name="Stereotype" value="table"/>
			<Column name="NType" value="17"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-26 01:33:37"/>
			<Column name="ModifiedDate" value="2026-04-26 01:33:37"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA2" value="MySql"/>
			<Column name="PDATA4" value="0"/>
			<Column name="GenType" value="MySql"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{5B186279-D6A5-4612-A233-2C55FD32D359}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="19"/>
			<Column name="Object_Type" value="Class"/>
			<Column name="Diagram_ID" value="0"/>
			<Column name="Name" value="Affectation"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="Version" value="1.0"/>
			<Column name="Package_ID" value="2"/>
			<Column name="NType" value="17"/>
			<Column name="Complexity" value="1"/>
			<Column name="Effort" value="0"/>
			<Column name="Backcolor" value="-1"/>
			<Column name="BorderStyle" value="0"/>
			<Column name="BorderWidth" value="-1"/>
			<Column name="Fontcolor" value="-1"/>
			<Column name="Bordercolor" value="-1"/>
			<Column name="CreatedDate" value="2026-04-23 00:31:53"/>
			<Column name="ModifiedDate" value="2026-04-26 01:04:42"/>
			<Column name="Status" value="Proposed"/>
			<Column name="Abstract" value="0"/>
			<Column name="Tagged" value="0"/>
			<Column name="PDATA4" value="8"/>
			<Column name="GenType" value="Java"/>
			<Column name="GenFile" value="C:\users\jub-ubuntu\Videos\PROJET_STAGE_NEW_DEV\New Folder\Affectation.java"/>
			<Column name="Phase" value="1.0"/>
			<Column name="Scope" value="Public"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{FC0FF3B3-0C69-4bdc-BF3E-16FC7F548FC6}"/>
			<Column name="ParentID" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsSpec" value="0"/>
			<Column name="IsActive" value="0"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}" PDATA4="{34817746-24CF-4c95-93F0-693B3A27BB5A}"/>
		</Row>
	</Table>
	<Table name="t_objectproperties">
		<Row>
			<Column name="PropertyID" value="37"/>
			<Column name="Object_ID" value="35"/>
			<Column name="Property" value="Owner"/>
			<Column name="ea_guid" value="{081BC26B-53CF-db53-8223-F5DB107EE6BE}"/>
			<Extension Object_ID="{0253C706-2C51-42d9-A611-3F09FA19C5C0}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="31"/>
			<Column name="Object_ID" value="33"/>
			<Column name="Property" value="Owner"/>
			<Column name="ea_guid" value="{081BC26B-53CF-db53-87DA-B35F1B0FDA7F}"/>
			<Extension Object_ID="{58A3CC04-A720-407d-81DC-DB30D3247A09}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="43"/>
			<Column name="Object_ID" value="37"/>
			<Column name="Property" value="Owner"/>
			<Column name="ea_guid" value="{081BC26B-53CF-db53-87F1-8189D821E8F3}"/>
			<Extension Object_ID="{2097F4D6-2054-4096-A530-4B473039D622}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="46"/>
			<Column name="Object_ID" value="38"/>
			<Column name="Property" value="Owner"/>
			<Column name="ea_guid" value="{081BC26B-53CF-db53-8EE3-0428177F1569}"/>
			<Extension Object_ID="{930F4F1D-C6CA-4ee9-A1C3-F7A85CC03D63}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="40"/>
			<Column name="Object_ID" value="36"/>
			<Column name="Property" value="Owner"/>
			<Column name="ea_guid" value="{081BC26B-53CF-db53-9C9A-82D62AB842D9}"/>
			<Extension Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="52"/>
			<Column name="Object_ID" value="40"/>
			<Column name="Property" value="Owner"/>
			<Column name="ea_guid" value="{081BC26B-53CF-db53-A38F-69DFE3C36C43}"/>
			<Extension Object_ID="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="49"/>
			<Column name="Object_ID" value="39"/>
			<Column name="Property" value="Owner"/>
			<Column name="ea_guid" value="{081BC26B-53CF-db53-ADC6-0A53D7DE1E5A}"/>
			<Extension Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="34"/>
			<Column name="Object_ID" value="34"/>
			<Column name="Property" value="Owner"/>
			<Column name="ea_guid" value="{081BC26B-53CF-db53-B4DE-07AC84319EB7}"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="28"/>
			<Column name="Object_ID" value="32"/>
			<Column name="Property" value="Owner"/>
			<Column name="ea_guid" value="{081BC26B-53CF-db53-B951-69C5D824A2C8}"/>
			<Extension Object_ID="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="44"/>
			<Column name="Object_ID" value="37"/>
			<Column name="Property" value="DBVersion"/>
			<Column name="ea_guid" value="{6110716C-E090-bfe0-8027-404226552D02}"/>
			<Extension Object_ID="{2097F4D6-2054-4096-A530-4B473039D622}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="47"/>
			<Column name="Object_ID" value="38"/>
			<Column name="Property" value="DBVersion"/>
			<Column name="ea_guid" value="{6110716C-E090-bfe0-8D2A-B20CFAE34756}"/>
			<Extension Object_ID="{930F4F1D-C6CA-4ee9-A1C3-F7A85CC03D63}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="29"/>
			<Column name="Object_ID" value="32"/>
			<Column name="Property" value="DBVersion"/>
			<Column name="ea_guid" value="{6110716C-E090-bfe0-925D-B7ECD8725F97}"/>
			<Extension Object_ID="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="38"/>
			<Column name="Object_ID" value="35"/>
			<Column name="Property" value="DBVersion"/>
			<Column name="ea_guid" value="{6110716C-E090-bfe0-97DE-208C41C19FA9}"/>
			<Extension Object_ID="{0253C706-2C51-42d9-A611-3F09FA19C5C0}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="35"/>
			<Column name="Object_ID" value="34"/>
			<Column name="Property" value="DBVersion"/>
			<Column name="ea_guid" value="{6110716C-E090-bfe0-A02A-31B9DD957400}"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="41"/>
			<Column name="Object_ID" value="36"/>
			<Column name="Property" value="DBVersion"/>
			<Column name="ea_guid" value="{6110716C-E090-bfe0-A695-C6BB4FAD0109}"/>
			<Extension Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="50"/>
			<Column name="Object_ID" value="39"/>
			<Column name="Property" value="DBVersion"/>
			<Column name="ea_guid" value="{6110716C-E090-bfe0-A768-E6461C8ED73E}"/>
			<Extension Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="53"/>
			<Column name="Object_ID" value="40"/>
			<Column name="Property" value="DBVersion"/>
			<Column name="ea_guid" value="{6110716C-E090-bfe0-A8AF-5D3AF39FFF76}"/>
			<Extension Object_ID="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="32"/>
			<Column name="Object_ID" value="33"/>
			<Column name="Property" value="DBVersion"/>
			<Column name="ea_guid" value="{6110716C-E090-bfe0-AE38-90A7B9EEC795}"/>
			<Extension Object_ID="{58A3CC04-A720-407d-81DC-DB30D3247A09}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="54"/>
			<Column name="Object_ID" value="40"/>
			<Column name="Property" value="Tablespace"/>
			<Column name="ea_guid" value="{D6AED194-E178-14e1-9463-8BF8CB039196}"/>
			<Extension Object_ID="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="30"/>
			<Column name="Object_ID" value="32"/>
			<Column name="Property" value="Tablespace"/>
			<Column name="ea_guid" value="{D6AED194-E178-14e1-9B28-1C0188DA3A8B}"/>
			<Extension Object_ID="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="36"/>
			<Column name="Object_ID" value="34"/>
			<Column name="Property" value="Tablespace"/>
			<Column name="ea_guid" value="{D6AED194-E178-14e1-9C01-85D44AB2DAEC}"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="42"/>
			<Column name="Object_ID" value="36"/>
			<Column name="Property" value="Tablespace"/>
			<Column name="ea_guid" value="{D6AED194-E178-14e1-9C9D-9DF4F6B12AF0}"/>
			<Extension Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="45"/>
			<Column name="Object_ID" value="37"/>
			<Column name="Property" value="Tablespace"/>
			<Column name="ea_guid" value="{D6AED194-E178-14e1-9DFC-36A12B10644D}"/>
			<Extension Object_ID="{2097F4D6-2054-4096-A530-4B473039D622}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="48"/>
			<Column name="Object_ID" value="38"/>
			<Column name="Property" value="Tablespace"/>
			<Column name="ea_guid" value="{D6AED194-E178-14e1-A5A0-A24AD99503CA}"/>
			<Extension Object_ID="{930F4F1D-C6CA-4ee9-A1C3-F7A85CC03D63}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="51"/>
			<Column name="Object_ID" value="39"/>
			<Column name="Property" value="Tablespace"/>
			<Column name="ea_guid" value="{D6AED194-E178-14e1-A81D-64B8975F1A34}"/>
			<Extension Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="39"/>
			<Column name="Object_ID" value="35"/>
			<Column name="Property" value="Tablespace"/>
			<Column name="ea_guid" value="{D6AED194-E178-14e1-A998-A12C4C10679F}"/>
			<Extension Object_ID="{0253C706-2C51-42d9-A611-3F09FA19C5C0}"/>
		</Row>
		<Row>
			<Column name="PropertyID" value="33"/>
			<Column name="Object_ID" value="33"/>
			<Column name="Property" value="Tablespace"/>
			<Column name="ea_guid" value="{D6AED194-E178-14e1-BE42-39DA6609BE97}"/>
			<Extension Object_ID="{58A3CC04-A720-407d-81DC-DB30D3247A09}"/>
		</Row>
	</Table>
	<Table name="t_attribute">
		<Row>
			<Column name="Object_ID" value="6"/>
			<Column name="Name" value="dateLivraisonEstimee"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="16"/>
			<Column name="Pos" value="4"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="Date"/>
			<Column name="ea_guid" value="{0378EB89-2248-4353-B573-2514BABF3254}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{A02A9B57-1644-4ac6-9CF0-CA35B54DBA0E}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="4"/>
			<Column name="Name" value="DEVELOPPEMENT"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="enum"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="6"/>
			<Column name="Pos" value="1"/>
			<Column name="ea_guid" value="{0D933147-4D08-4967-A5D5-431405D98BDF}"/>
			<Column name="StyleEx" value="IsLiteral=1;volatile=0;"/>
			<Extension Object_ID="{27A8DAE9-616D-4564-AA2E-32FB0344CCB2}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="12"/>
			<Column name="Name" value="typeTechno"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="36"/>
			<Column name="Pos" value="2"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="TypeTechno"/>
			<Column name="ea_guid" value="{0E95CB79-E911-45da-8768-36B6C9F22AF7}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{74933CA6-06EB-4103-B908-1B97053678E9}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="33"/>
			<Column name="Name" value="ClientID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="1"/>
			<Column name="AllowDuplicates" value="1"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="96"/>
			<Column name="Pos" value="4"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{130A6636-3AA9-48fe-9666-347F8FC95770}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{58A3CC04-A720-407d-81DC-DB30D3247A09}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="36"/>
			<Column name="Name" value="Datelancement"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="110"/>
			<Column name="Pos" value="3"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="DATE"/>
			<Column name="ea_guid" value="{150267EC-F434-47a6-8659-57B37E981EC0}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="32"/>
			<Column name="Name" value="ProjetID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="1"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="130"/>
			<Column name="Pos" value="3"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{153A0B4E-BD4F-441d-B6F1-6E57A87E4D9C}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="20"/>
			<Column name="Name" value="version"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="42"/>
			<Column name="Pos" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{17DCC0E0-CEF7-4262-A0EF-1CDB60A27D41}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{9E44FF21-E97C-4393-B87A-660FBF7BFA60}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="36"/>
			<Column name="Name" value="Datelivraisonestimee"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="111"/>
			<Column name="Pos" value="4"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="DATE"/>
			<Column name="ea_guid" value="{18170C85-8D87-4032-BA9C-61F353768AB4}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="4"/>
			<Column name="Name" value="PRODUCTION"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="enum"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="8"/>
			<Column name="Pos" value="3"/>
			<Column name="ea_guid" value="{1A627E84-5ABD-46e1-866A-4E2BC7407776}"/>
			<Column name="StyleEx" value="IsLiteral=1;volatile=0;"/>
			<Extension Object_ID="{27A8DAE9-616D-4564-AA2E-32FB0344CCB2}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="8"/>
			<Column name="Name" value="email"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="24"/>
			<Column name="Pos" value="4"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{1D853D24-48EB-4cdd-B7E4-C681DDDAC89E}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{9C36619A-26FA-49f9-8ECE-B23BEAB870CC}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="34"/>
			<Column name="Name" value="Typeenv"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="98"/>
			<Column name="Pos" value="1"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="varchar"/>
			<Column name="ea_guid" value="{25541B56-B77B-4bfe-8563-9761107F3D89}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="39"/>
			<Column name="Name" value="Prenomuser"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="124"/>
			<Column name="Pos" value="2"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{28F28388-85DE-458f-83EE-3EBD59EB3754}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="7"/>
			<Column name="Name" value="prenomClient"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="141"/>
			<Column name="Pos" value="2"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{296CAC65-F26B-4190-BD2E-E380B65E9338}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{A7B42C3B-9BA7-444a-9164-53DF80D177BF}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="2"/>
			<Column name="Name" value="LIVRE"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="enum"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="3"/>
			<Column name="Pos" value="2"/>
			<Column name="ea_guid" value="{33334975-F9F2-4e6c-946B-AD5EEBEC97D0}"/>
			<Column name="StyleEx" value="IsLiteral=1;volatile=0;"/>
			<Extension Object_ID="{666B04EE-1C5C-4438-B2AD-8DC7274ECADA}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="6"/>
			<Column name="Name" value="descriptionTech"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="14"/>
			<Column name="Pos" value="2"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{3348E9D6-83B1-41f7-AA3D-DF935EB3D35F}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{A02A9B57-1644-4ac6-9CF0-CA35B54DBA0E}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="36"/>
			<Column name="Name" value="Statutprojet"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="112"/>
			<Column name="Pos" value="5"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="varchar"/>
			<Column name="ea_guid" value="{33C890B0-E904-4859-BE0C-62CD0402AA3C}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="37"/>
			<Column name="Name" value="Adressip"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="115"/>
			<Column name="Pos" value="1"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{3607F91F-A939-4183-BBAB-42A059B88598}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{2097F4D6-2054-4096-A530-4B473039D622}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="44"/>
			<Column name="Name" value="CHEF_PROJET"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="enum"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="138"/>
			<Column name="Pos" value="0"/>
			<Column name="ea_guid" value="{37DC2EC4-3287-418f-82AD-144FF82444C9}"/>
			<Column name="StyleEx" value="IsLiteral=1;volatile=0;"/>
			<Extension Object_ID="{583F726F-3BD9-4c63-BE4D-8C75344A2D45}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="40"/>
			<Column name="Name" value="TechnologieID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="1"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="134"/>
			<Column name="Pos" value="4"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{381D7887-FAB3-423e-B265-E2646AA5FBA8}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="39"/>
			<Column name="Name" value="Email"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="125"/>
			<Column name="Pos" value="3"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{3E6CC30C-B496-4ec0-BF28-34D48ED87444}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="33"/>
			<Column name="Name" value="Idclient"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="93"/>
			<Column name="Pos" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="varchar"/>
			<Column name="ea_guid" value="{411D75FD-B652-4d03-9E67-AD2270BB7FBF}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{58A3CC04-A720-407d-81DC-DB30D3247A09}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="38"/>
			<Column name="Name" value="Nomtechno"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="119"/>
			<Column name="Pos" value="1"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{41917495-D431-441c-AEBE-FD49A0112E70}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{930F4F1D-C6CA-4ee9-A1C3-F7A85CC03D63}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="7"/>
			<Column name="Name" value="nomClient"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="19"/>
			<Column name="Pos" value="1"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{42AC716C-2A7B-45da-8921-9613F18EFC4C}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{A7B42C3B-9BA7-444a-9164-53DF80D177BF}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="14"/>
			<Column name="Name" value="os"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="40"/>
			<Column name="Pos" value="2"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{4CC92F66-F654-46e9-9594-A80A1AD10BC0}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{C2AC65EB-1D25-4d3e-859F-C48D308DB514}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="34"/>
			<Column name="Name" value="EnvironnementID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="1"/>
			<Column name="AllowDuplicates" value="1"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="103"/>
			<Column name="Pos" value="7"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{4DFE76DC-D4F3-4faf-8E27-21B138E61403}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="11"/>
			<Column name="Name" value="notes"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="33"/>
			<Column name="Pos" value="5"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="Text"/>
			<Column name="ea_guid" value="{50BE79C1-35BB-45a7-AB39-CD5FEE6D908C}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{1C8F4B2F-BAB5-4328-9F44-F9CA3721015D}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="39"/>
			<Column name="Name" value="Password"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="126"/>
			<Column name="Pos" value="4"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{541A65BA-67FD-4bf8-9F75-4A2F67565661}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="34"/>
			<Column name="Name" value="Urlback"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="101"/>
			<Column name="Pos" value="4"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{5C435504-5D2F-4183-A36A-8A21711B2C1C}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="11"/>
			<Column name="Name" value="urlBack"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="32"/>
			<Column name="Pos" value="4"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{5D10C153-2498-496a-8326-D2C7A60EACC0}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{1C8F4B2F-BAB5-4328-9F44-F9CA3721015D}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="35"/>
			<Column name="Name" value="ProfilID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="1"/>
			<Column name="AllowDuplicates" value="1"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="106"/>
			<Column name="Pos" value="3"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{5E0E23D4-F1E9-4227-8B53-B74A87AEC92F}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{0253C706-2C51-42d9-A611-3F09FA19C5C0}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="8"/>
			<Column name="Name" value="password"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="25"/>
			<Column name="Pos" value="5"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{6036AA71-865D-4130-8D6F-0CAD4D919411}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{9C36619A-26FA-49f9-8ECE-B23BEAB870CC}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="2"/>
			<Column name="Name" value="EN_COURS"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="enum"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="1"/>
			<Column name="Pos" value="0"/>
			<Column name="ea_guid" value="{67D39D17-C903-4713-B5B4-A8939A92F8B4}"/>
			<Column name="StyleEx" value="IsLiteral=1;volatile=0;"/>
			<Extension Object_ID="{666B04EE-1C5C-4438-B2AD-8DC7274ECADA}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="39"/>
			<Column name="Name" value="Nomuser"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="123"/>
			<Column name="Pos" value="1"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{7074AA1D-8410-45d2-BC85-C7061BED2EAA}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="14"/>
			<Column name="Name" value="adressIP"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="39"/>
			<Column name="Pos" value="1"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{78BA42DF-BBDD-4351-AA10-FD3E4832E83B}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{C2AC65EB-1D25-4d3e-859F-C48D308DB514}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="39"/>
			<Column name="Name" value="Iduser"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="122"/>
			<Column name="Pos" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="varchar"/>
			<Column name="ea_guid" value="{7A20F9D7-C1F4-4db9-A57D-442E48E3FA35}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="14"/>
			<Column name="Name" value="idServ"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="38"/>
			<Column name="Pos" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="UUID"/>
			<Column name="ea_guid" value="{7E9EC65A-1729-48ab-8E9F-6C339BBF4ABC}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{C2AC65EB-1D25-4d3e-859F-C48D308DB514}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="6"/>
			<Column name="Name" value="idProjet"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="12"/>
			<Column name="Pos" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="UUID"/>
			<Column name="ea_guid" value="{80C25B3A-9AB2-4b25-9302-E3F7BE8CDBCA}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{A02A9B57-1644-4ac6-9CF0-CA35B54DBA0E}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="19"/>
			<Column name="Name" value="roleProjet"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="41"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="RoleProjet"/>
			<Column name="ea_guid" value="{82610527-76F6-4783-B914-6825B0B8F908}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{FC0FF3B3-0C69-4bdc-BF3E-16FC7F548FC6}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="12"/>
			<Column name="Name" value="idTechno"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="34"/>
			<Column name="Pos" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="UUID"/>
			<Column name="ea_guid" value="{830BF7AE-268D-41a4-B738-896FBADF8082}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{74933CA6-06EB-4103-B908-1B97053678E9}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="33"/>
			<Column name="Name" value="Nomclient"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="94"/>
			<Column name="Pos" value="1"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{83918A54-7D16-441d-8AEA-A1CBEC93F2ED}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{58A3CC04-A720-407d-81DC-DB30D3247A09}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="36"/>
			<Column name="Name" value="ProjetID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="1"/>
			<Column name="AllowDuplicates" value="1"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="113"/>
			<Column name="Pos" value="7"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{8456999B-3887-4c29-823F-F7A5755FAA3D}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="11"/>
			<Column name="Name" value="idEnv"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="29"/>
			<Column name="Pos" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="UUID"/>
			<Column name="ea_guid" value="{848983A9-EDEF-48ec-A4BA-E0547A99B178}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{1C8F4B2F-BAB5-4328-9F44-F9CA3721015D}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="38"/>
			<Column name="Name" value="Idtechno"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="118"/>
			<Column name="Pos" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="varchar"/>
			<Column name="ea_guid" value="{8617DFA9-615B-4a90-AF0B-7F404DCE8559}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{930F4F1D-C6CA-4ee9-A1C3-F7A85CC03D63}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="34"/>
			<Column name="Name" value="Nombasededonnees"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="99"/>
			<Column name="Pos" value="2"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{86B96CDE-8198-4c0b-B345-FE2D9C1153D2}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="38"/>
			<Column name="Name" value="TechnologieID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="1"/>
			<Column name="AllowDuplicates" value="1"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="121"/>
			<Column name="Pos" value="4"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{894D61BA-BB6C-4738-955B-4B3B7FE0FB3F}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{930F4F1D-C6CA-4ee9-A1C3-F7A85CC03D63}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="32"/>
			<Column name="Name" value="Roleprojet"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="91"/>
			<Column name="Pos" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{8B75C004-9A7E-46ff-B40E-017347D1F34B}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="11"/>
			<Column name="Name" value="urlFront"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="31"/>
			<Column name="Pos" value="3"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{901518C7-DF7A-48ce-8149-E36E0089B930}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{1C8F4B2F-BAB5-4328-9F44-F9CA3721015D}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="2"/>
			<Column name="Name" value="ANNULE"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="enum"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="4"/>
			<Column name="Pos" value="3"/>
			<Column name="ea_guid" value="{90BC064D-2422-4a1d-A161-A9D8210C2D6C}"/>
			<Column name="StyleEx" value="IsLiteral=1;volatile=0;"/>
			<Extension Object_ID="{666B04EE-1C5C-4438-B2AD-8DC7274ECADA}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="36"/>
			<Column name="Name" value="Idprojet"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="107"/>
			<Column name="Pos" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="varchar"/>
			<Column name="ea_guid" value="{91759616-6475-4837-A260-C674498940A5}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="40"/>
			<Column name="Name" value="EnvironnementID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="1"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="133"/>
			<Column name="Pos" value="3"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{93439019-0116-4c75-BEEC-6249861BC9C5}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="4"/>
			<Column name="Name" value="LOCAL"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="enum"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="5"/>
			<Column name="Pos" value="0"/>
			<Column name="ea_guid" value="{9B0ED433-B251-4c69-8E25-BD21C8D51755}"/>
			<Column name="StyleEx" value="IsLiteral=1;volatile=0;"/>
			<Extension Object_ID="{27A8DAE9-616D-4564-AA2E-32FB0344CCB2}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="6"/>
			<Column name="Name" value="dateLancement"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="15"/>
			<Column name="Pos" value="3"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="Date"/>
			<Column name="ea_guid" value="{9B388284-F756-421d-B34A-1F666E28D84E}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{A02A9B57-1644-4ac6-9CF0-CA35B54DBA0E}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="11"/>
			<Column name="Name" value="typeEnv"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="30"/>
			<Column name="Pos" value="1"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="TypeEnvironnement"/>
			<Column name="ea_guid" value="{9B7E1243-C792-4535-8C14-EE00024C3CB8}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{1C8F4B2F-BAB5-4328-9F44-F9CA3721015D}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="36"/>
			<Column name="Name" value="Nomprojet"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="108"/>
			<Column name="Pos" value="1"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{9C706C0F-AD0D-4034-B809-D6B6866795EC}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="12"/>
			<Column name="Name" value="nomTechno"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="35"/>
			<Column name="Pos" value="1"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{A8286FA9-3E9F-4081-9365-B324F2DAF49B}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{74933CA6-06EB-4103-B908-1B97053678E9}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="39"/>
			<Column name="Name" value="UtilisateurID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="1"/>
			<Column name="AllowDuplicates" value="1"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="127"/>
			<Column name="Pos" value="6"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{AA2B2BF9-092B-465d-B968-852B79E017E3}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="7"/>
			<Column name="Name" value="idClient"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="18"/>
			<Column name="Pos" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="UUID"/>
			<Column name="ea_guid" value="{AC1B2CA6-99A8-4d43-BD03-6519E246CC6B}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{A7B42C3B-9BA7-444a-9164-53DF80D177BF}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="34"/>
			<Column name="Name" value="Idenv"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="97"/>
			<Column name="Pos" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="varchar"/>
			<Column name="ea_guid" value="{AC957583-A735-40fb-B2E7-AC474075A35F}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="2"/>
			<Column name="Name" value="EN_PAUSE"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="enum"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="2"/>
			<Column name="Pos" value="1"/>
			<Column name="ea_guid" value="{AE7B746D-996F-4d05-A642-4935D8C0CC5C}"/>
			<Column name="StyleEx" value="IsLiteral=1;volatile=0;"/>
			<Extension Object_ID="{666B04EE-1C5C-4438-B2AD-8DC7274ECADA}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="36"/>
			<Column name="Name" value="Descriptiontech"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="109"/>
			<Column name="Pos" value="2"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{B910DA63-7BAB-4d7a-A1FE-4EDFFF2258CE}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="9"/>
			<Column name="Name" value="idProfil"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="26"/>
			<Column name="Pos" value="0"/>
			<Column name="Type" value="int"/>
			<Column name="ea_guid" value="{BA055BA8-AC11-43c1-985C-3EF4F56A1E68}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{3DE948F4-C3A6-46d9-B8AD-C94607E24D09}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="37"/>
			<Column name="Name" value="Idserv"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="114"/>
			<Column name="Pos" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="varchar"/>
			<Column name="ea_guid" value="{BFDF1B30-DC55-4f37-935B-491A4C281955}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{2097F4D6-2054-4096-A530-4B473039D622}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="39"/>
			<Column name="Name" value="ProfilID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="1"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="137"/>
			<Column name="Pos" value="7"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{BFFAB5BF-3164-4b21-B7EF-E01393054569}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="8"/>
			<Column name="Name" value="genre"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="140"/>
			<Column name="Pos" value="3"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{C1CD31EB-2B04-4c28-8502-257102CD3BC9}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{9C36619A-26FA-49f9-8ECE-B23BEAB870CC}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="5"/>
			<Column name="Name" value="SGBD"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="enum"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="11"/>
			<Column name="Pos" value="2"/>
			<Column name="ea_guid" value="{C52A4F56-E701-4492-B6C8-5F0A4E590871}"/>
			<Column name="StyleEx" value="IsLiteral=1;volatile=0;"/>
			<Extension Object_ID="{8C149F02-5496-4a6d-8BD2-67DD97909651}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="44"/>
			<Column name="Name" value="DEVELOPPEUR"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="enum"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="139"/>
			<Column name="Pos" value="1"/>
			<Column name="ea_guid" value="{C6685B47-557F-40d8-8324-83F4A0D37313}"/>
			<Column name="StyleEx" value="IsLiteral=1;volatile=0;"/>
			<Extension Object_ID="{583F726F-3BD9-4c63-BE4D-8C75344A2D45}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="35"/>
			<Column name="Name" value="Idprofil"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="104"/>
			<Column name="Pos" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{C6BF386A-3091-4c7f-B181-7AD9A147E53E}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{0253C706-2C51-42d9-A611-3F09FA19C5C0}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="5"/>
			<Column name="Name" value="FRAMEWORK"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="enum"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="10"/>
			<Column name="Pos" value="1"/>
			<Column name="ea_guid" value="{C7C70D81-770A-4f22-BEF7-9501532B616E}"/>
			<Column name="StyleEx" value="IsLiteral=1;volatile=0;"/>
			<Extension Object_ID="{8C149F02-5496-4a6d-8BD2-67DD97909651}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="6"/>
			<Column name="Name" value="nomProjet"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="13"/>
			<Column name="Pos" value="1"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{CB9C7C19-DB1A-464d-88EA-AF6A98268CB5}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{A02A9B57-1644-4ac6-9CF0-CA35B54DBA0E}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="11"/>
			<Column name="Name" value="nomBaseDeDonnees"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="43"/>
			<Column name="Pos" value="2"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{CF48747B-32C8-4129-A414-C8EE1F32E41B}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{1C8F4B2F-BAB5-4328-9F44-F9CA3721015D}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="8"/>
			<Column name="Name" value="idUser"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="21"/>
			<Column name="Pos" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="UUID"/>
			<Column name="ea_guid" value="{D5C1F04A-3F14-4428-A0EE-9E929BBB7094}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{9C36619A-26FA-49f9-8ECE-B23BEAB870CC}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="5"/>
			<Column name="Name" value="LANGAGE"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="enum"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="9"/>
			<Column name="Pos" value="0"/>
			<Column name="ea_guid" value="{D648AB0F-8AC2-4767-A71C-8DC9763C5CDB}"/>
			<Column name="StyleEx" value="IsLiteral=1;volatile=0;"/>
			<Extension Object_ID="{8C149F02-5496-4a6d-8BD2-67DD97909651}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="35"/>
			<Column name="Name" value="Libelle"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="105"/>
			<Column name="Pos" value="1"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{D64A5E2A-9BFB-4a6c-BB03-7B67C8E1C2DD}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{0253C706-2C51-42d9-A611-3F09FA19C5C0}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="9"/>
			<Column name="Name" value="libelle"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="27"/>
			<Column name="Pos" value="1"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{D765BAB5-B739-472e-95B8-C2092EA8E63A}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{3DE948F4-C3A6-46d9-B8AD-C94607E24D09}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="8"/>
			<Column name="Name" value="nomUser"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="22"/>
			<Column name="Pos" value="1"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{DC36BA81-B2B6-47cf-A07B-9DF6434E6C5E}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{9C36619A-26FA-49f9-8ECE-B23BEAB870CC}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="4"/>
			<Column name="Name" value="STAGING"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="enum"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="7"/>
			<Column name="Pos" value="2"/>
			<Column name="ea_guid" value="{E167433D-AB81-4968-8EF0-617635190618}"/>
			<Column name="StyleEx" value="IsLiteral=1;volatile=0;"/>
			<Extension Object_ID="{27A8DAE9-616D-4564-AA2E-32FB0344CCB2}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="40"/>
			<Column name="Name" value="VersiontechnoID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="1"/>
			<Column name="AllowDuplicates" value="1"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="129"/>
			<Column name="Pos" value="2"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{E2967D20-1CF2-4889-8625-93009DF57635}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="6"/>
			<Column name="Name" value="pourcentageAvancement"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="142"/>
			<Column name="Pos" value="6"/>
			<Column name="Type" value="int"/>
			<Column name="ea_guid" value="{E2A5792C-AE56-46fc-BACF-076BE9CAB2DE}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{A02A9B57-1644-4ac6-9CF0-CA35B54DBA0E}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="32"/>
			<Column name="Name" value="UtilisateurID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="1"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="131"/>
			<Column name="Pos" value="4"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{E54EF0A2-73EE-494a-AD1D-7CAD70D08599}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="6"/>
			<Column name="Name" value="statutProjet"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="17"/>
			<Column name="Pos" value="5"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="StatutProjet"/>
			<Column name="ea_guid" value="{E58BB58E-00AE-4a36-8808-5B0BA0C9EA47}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{A02A9B57-1644-4ac6-9CF0-CA35B54DBA0E}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="37"/>
			<Column name="Name" value="Os"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="116"/>
			<Column name="Pos" value="2"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{E78FF488-74B2-4d88-9033-D2E49CE95C53}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{2097F4D6-2054-4096-A530-4B473039D622}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="36"/>
			<Column name="Name" value="ClientID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="1"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="132"/>
			<Column name="Pos" value="8"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{E87D5A1D-A2A3-4503-B255-8356434811AA}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="7"/>
			<Column name="Name" value="entrepriseClient"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="20"/>
			<Column name="Pos" value="3"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{E983129E-6754-47ff-8F27-AC38AE0D7B26}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{A7B42C3B-9BA7-444a-9164-53DF80D177BF}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="40"/>
			<Column name="Name" value="Version"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="128"/>
			<Column name="Pos" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{EADD6899-84B5-4fe1-A862-4BBD05CC2982}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="37"/>
			<Column name="Name" value="ServeurID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="1"/>
			<Column name="AllowDuplicates" value="1"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="117"/>
			<Column name="Pos" value="4"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{EAE6C3B9-4ACB-4c7d-B917-1D5392BF19B9}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{2097F4D6-2054-4096-A530-4B473039D622}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="34"/>
			<Column name="Name" value="Urlfront"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="100"/>
			<Column name="Pos" value="3"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{EDFB6ED0-F7F4-474c-8E70-31F61125646C}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="32"/>
			<Column name="Name" value="AffectationID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="1"/>
			<Column name="AllowDuplicates" value="1"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="92"/>
			<Column name="Pos" value="2"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{EE300622-5C3F-42e2-853A-685BCA6C377F}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="38"/>
			<Column name="Name" value="Typetechno"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="120"/>
			<Column name="Pos" value="2"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="varchar"/>
			<Column name="ea_guid" value="{F6029C55-3C00-4e0c-97BD-F0A6EF0006D2}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{930F4F1D-C6CA-4ee9-A1C3-F7A85CC03D63}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="34"/>
			<Column name="Name" value="Notes"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="102"/>
			<Column name="Pos" value="5"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="TEXT"/>
			<Column name="ea_guid" value="{F6908F11-566E-4ca7-AA8B-45AD2C35C6A1}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="34"/>
			<Column name="Name" value="ServeurID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="1"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="135"/>
			<Column name="Pos" value="8"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{F6ED4473-570D-4804-93BF-5EFC4FD61383}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="8"/>
			<Column name="Name" value="prenomUser"/>
			<Column name="Scope" value="Private"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="ID" value="23"/>
			<Column name="Pos" value="2"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="String"/>
			<Column name="ea_guid" value="{FC224A17-F395-43d5-9CDE-8B3B0EC168E7}"/>
			<Column name="StyleEx" value="volatile=0;"/>
			<Extension Object_ID="{9C36619A-26FA-49f9-8ECE-B23BEAB870CC}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="33"/>
			<Column name="Name" value="Entrepriseclient"/>
			<Column name="Scope" value="Private"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="0"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="95"/>
			<Column name="Pos" value="2"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Length" value="50"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="VARCHAR"/>
			<Column name="ea_guid" value="{FCF2BC47-F223-4282-8378-965FF11F235F}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{58A3CC04-A720-407d-81DC-DB30D3247A09}"/>
		</Row>
		<Row>
			<Column name="Object_ID" value="34"/>
			<Column name="Name" value="ProjetID"/>
			<Column name="Scope" value="Public"/>
			<Column name="Stereotype" value="column"/>
			<Column name="Containment" value="Not Specified"/>
			<Column name="IsStatic" value="0"/>
			<Column name="IsCollection" value="1"/>
			<Column name="IsOrdered" value="0"/>
			<Column name="AllowDuplicates" value="0"/>
			<Column name="LowerBound" value="1"/>
			<Column name="UpperBound" value="1"/>
			<Column name="Derived" value="0"/>
			<Column name="ID" value="136"/>
			<Column name="Pos" value="9"/>
			<Column name="Length" value="0"/>
			<Column name="Precision" value="0"/>
			<Column name="Scale" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="ea_guid" value="{FF0A5386-FB77-4ce2-9E21-95F46BEF641B}"/>
			<Column name="StyleEx" value="volatile=0;union=0;"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
	</Table>
	<Table name="t_attributetag">
		<Row>
			<Column name="PropertyID" value="1"/>
			<Column name="ElementID" value="14"/>
			<Column name="Property" value="DBType"/>
			<Column name="VALUE" value="TEXT"/>
			<Column name="ea_guid" value="{623794A7-B467-4d89-B29B-76C319129AA3}"/>
			<Extension ElementID="{3348E9D6-83B1-41f7-AA3D-DF935EB3D35F}"/>
		</Row>
	</Table>
	<Table name="t_operation">
		<Row>
			<Column name="OperationID" value="21"/>
			<Column name="Object_ID" value="35"/>
			<Column name="Name" value="PK_Profil"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="PK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{0413BA96-976C-47bc-9258-280D3EB4496C}"/>
			<Extension Object_ID="{0253C706-2C51-42d9-A611-3F09FA19C5C0}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="22"/>
			<Column name="Object_ID" value="36"/>
			<Column name="Name" value="PK_Projet"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="PK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{153D2402-5F31-4330-BB1B-9D64EAACD13A}"/>
			<Extension Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="33"/>
			<Column name="Object_ID" value="34"/>
			<Column name="Name" value="FK_Environnement_contient"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="2"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{24216EE7-E9AA-4d93-B058-3C03CF2FCE9E}"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="30"/>
			<Column name="Object_ID" value="40"/>
			<Column name="Name" value="FK_VersionTechno_Environnement"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="1"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{3A934217-C198-41d1-BD53-C8276AAF329C}"/>
			<Extension Object_ID="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="23"/>
			<Column name="Object_ID" value="37"/>
			<Column name="Name" value="PK_Serveur"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="PK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{3C52AEB7-E947-47be-98D1-76D2F7C1CC09}"/>
			<Extension Object_ID="{2097F4D6-2054-4096-A530-4B473039D622}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="32"/>
			<Column name="Object_ID" value="34"/>
			<Column name="Name" value="FK_Environnement_est hï¿½bergï¿½ sur"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="1"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{3DFDA890-A62A-4fb6-82B5-183CBF2A60B9}"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="24"/>
			<Column name="Object_ID" value="38"/>
			<Column name="Name" value="PK_Technologie"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="PK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{4CE15537-DD6D-45c1-9239-938E771281E1}"/>
			<Extension Object_ID="{930F4F1D-C6CA-4ee9-A1C3-F7A85CC03D63}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="20"/>
			<Column name="Object_ID" value="34"/>
			<Column name="Name" value="PK_Environnement"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="PK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{6FFF535A-076C-4014-AD7E-67E910E85515}"/>
			<Extension Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="28"/>
			<Column name="Object_ID" value="32"/>
			<Column name="Name" value="FK_Affectation_Utilisateur"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="2"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{8EF3604A-C6E9-4ac0-A73E-EA5EE627F2C8}"/>
			<Extension Object_ID="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="29"/>
			<Column name="Object_ID" value="36"/>
			<Column name="Name" value="FK_Projet_possï¿½de"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="1"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{9E733395-E1F8-41f8-848E-EBF4F483E3B0}"/>
			<Extension Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="34"/>
			<Column name="Object_ID" value="39"/>
			<Column name="Name" value="FK_Utilisateur_a pour"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="1"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{A6A3417B-0459-4526-B155-0788E27642FC}"/>
			<Extension Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="27"/>
			<Column name="Object_ID" value="32"/>
			<Column name="Name" value="FK_Affectation_Projet"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="1"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{AEBD4F8F-7BF5-420d-9420-93179C199C9D}"/>
			<Extension Object_ID="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="25"/>
			<Column name="Object_ID" value="39"/>
			<Column name="Name" value="PK_Utilisateur"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="PK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{C6A8666F-0638-4cbb-9827-83B9E7CA9250}"/>
			<Extension Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="19"/>
			<Column name="Object_ID" value="33"/>
			<Column name="Name" value="PK_Client"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="PK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{DF7584A8-161C-41bb-B676-BF8ACA05CE12}"/>
			<Extension Object_ID="{58A3CC04-A720-407d-81DC-DB30D3247A09}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="18"/>
			<Column name="Object_ID" value="32"/>
			<Column name="Name" value="PK_Affectation"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="PK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{E6D6708D-CDC8-4e5d-895A-37D5755E4F07}"/>
			<Extension Object_ID="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="26"/>
			<Column name="Object_ID" value="40"/>
			<Column name="Name" value="PK_Versiontechno"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="PK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="GenOption" value="SourceClass=true;"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{F245FBF7-78A0-4b7b-B6FB-EE4C7E360205}"/>
			<Extension Object_ID="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="31"/>
			<Column name="Object_ID" value="40"/>
			<Column name="Name" value="FK_VersionTechno_Technologie"/>
			<Column name="Scope" value="Public"/>
			<Column name="ReturnArray" value="0"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="IsStatic" value="0"/>
			<Column name="Concurrency" value="Sequential"/>
			<Column name="Abstract" value="0"/>
			<Column name="Synchronized" value="0"/>
			<Column name="Pos" value="2"/>
			<Column name="Const" value="0"/>
			<Column name="Pure" value="0"/>
			<Column name="Classifier" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="IsQuery" value="0"/>
			<Column name="ea_guid" value="{FBEF830F-7D3B-4dd5-A825-53AACEC91E3C}"/>
			<Extension Object_ID="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
		</Row>
	</Table>
	<Table name="t_operationparams">
		<Row>
			<Column name="OperationID" value="32"/>
			<Column name="Name" value="ServeurID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{090C4CE7-593C-4949-B67D-5125A99544AF}"/>
			<Extension OperationID="{3DFDA890-A62A-4fb6-82B5-183CBF2A60B9}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="29"/>
			<Column name="Name" value="ClientID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{55B3BE53-03E5-4729-9B6E-3975D2230A0A}"/>
			<Extension OperationID="{9E733395-E1F8-41f8-848E-EBF4F483E3B0}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="19"/>
			<Column name="Name" value="ClientID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{568687F9-BEDC-4947-8677-B1281D9C2726}"/>
			<Extension OperationID="{DF7584A8-161C-41bb-B676-BF8ACA05CE12}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="34"/>
			<Column name="Name" value="ProfilID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{5B54DDC4-8343-4ecc-B3A7-445C77BE5C00}"/>
			<Extension OperationID="{A6A3417B-0459-4526-B155-0788E27642FC}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="25"/>
			<Column name="Name" value="UtilisateurID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{7354731F-509D-4c7f-9E51-A7537ED1A4E7}"/>
			<Extension OperationID="{C6A8666F-0638-4cbb-9827-83B9E7CA9250}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="22"/>
			<Column name="Name" value="ProjetID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{745173A0-DBBE-4e8d-8B85-532B970C542A}"/>
			<Extension OperationID="{153D2402-5F31-4330-BB1B-9D64EAACD13A}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="24"/>
			<Column name="Name" value="TechnologieID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{81DB94DE-CA34-4190-962A-5AF6B51B5020}"/>
			<Extension OperationID="{4CE15537-DD6D-45c1-9239-938E771281E1}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="27"/>
			<Column name="Name" value="ProjetID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{8B60F7E2-8324-4969-9B31-E6A53122B802}"/>
			<Extension OperationID="{AEBD4F8F-7BF5-420d-9420-93179C199C9D}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="28"/>
			<Column name="Name" value="UtilisateurID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{A3D42125-0ABE-4a03-9A14-99369C491935}"/>
			<Extension OperationID="{8EF3604A-C6E9-4ac0-A73E-EA5EE627F2C8}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="31"/>
			<Column name="Name" value="TechnologieID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{A6CB433B-F520-4fec-8EAE-5B64CB7CDF2A}"/>
			<Extension OperationID="{FBEF830F-7D3B-4dd5-A825-53AACEC91E3C}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="23"/>
			<Column name="Name" value="ServeurID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{C74128BD-FA66-459f-91AD-7501B7802818}"/>
			<Extension OperationID="{3C52AEB7-E947-47be-98D1-76D2F7C1CC09}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="21"/>
			<Column name="Name" value="ProfilID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{CF804D6D-9B46-4a11-8C4E-E62FA47AA967}"/>
			<Extension OperationID="{0413BA96-976C-47bc-9258-280D3EB4496C}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="30"/>
			<Column name="Name" value="EnvironnementID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{D63944C0-3368-4b30-8A15-60AC77F9DC24}"/>
			<Extension OperationID="{3A934217-C198-41d1-BD53-C8276AAF329C}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="20"/>
			<Column name="Name" value="EnvironnementID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{DD86445B-BB2C-4cfe-9524-71476B7A167C}"/>
			<Extension OperationID="{6FFF535A-076C-4014-AD7E-67E910E85515}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="33"/>
			<Column name="Name" value="ProjetID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{DDA6CF32-7656-46b2-BF82-C24CA8288535}"/>
			<Extension OperationID="{24216EE7-E9AA-4d93-B058-3C03CF2FCE9E}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="26"/>
			<Column name="Name" value="VersiontechnoID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{E405B76B-2EE1-4557-AFC6-B19019EF3BEB}"/>
			<Extension OperationID="{F245FBF7-78A0-4b7b-B6FB-EE4C7E360205}"/>
		</Row>
		<Row>
			<Column name="OperationID" value="18"/>
			<Column name="Name" value="AffectationID"/>
			<Column name="Type" value="INTEGER"/>
			<Column name="Pos" value="0"/>
			<Column name="Const" value="0"/>
			<Column name="Kind" value="in"/>
			<Column name="Classifier" value="0"/>
			<Column name="ea_guid" value="{FAD19F26-6589-4d58-B11B-46AD4918A064}"/>
			<Extension OperationID="{E6D6708D-CDC8-4e5d-895A-37D5755E4F07}"/>
		</Row>
	</Table>
	<Table name="t_connector">
		<Row>
			<Column name="Connector_ID" value="14"/>
			<Column name="Name" value="contient"/>
			<Column name="Direction" value="Source -&gt; Destination"/>
			<Column name="Connector_Type" value="Aggregation"/>
			<Column name="SubType" value="Strong"/>
			<Column name="SourceCard" value="0..*"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="1"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="2"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="11"/>
			<Column name="End_Object_ID" value="6"/>
			<Column name="Top_Mid_Label" value="contient"/>
			<Column name="Btm_End_Label" value="1"/>
			<Column name="Start_Edge" value="4"/>
			<Column name="End_Edge" value="2"/>
			<Column name="PtStartX" value="666"/>
			<Column name="PtStartY" value="-254"/>
			<Column name="PtEndX" value="492"/>
			<Column name="PtEndY" value="-254"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="PDATA5" value="SX=0;SY=0;EX=0;EY=0;EDGE=4;"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{25B5477C-1627-4934-8200-F208F1FB894B}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="1"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Navigable;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Unspecified;"/>
			<Extension Start_Object_ID="{1C8F4B2F-BAB5-4328-9F44-F9CA3721015D}" End_Object_ID="{A02A9B57-1644-4ac6-9CF0-CA35B54DBA0E}"/>
		</Row>
		<Row>
			<Column name="Connector_ID" value="11"/>
			<Column name="Name" value="est hï¿½bergï¿½ sur"/>
			<Column name="Direction" value="Unspecified"/>
			<Column name="Connector_Type" value="Association"/>
			<Column name="SourceCard" value="0..*"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="1"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="0"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="11"/>
			<Column name="End_Object_ID" value="14"/>
			<Column name="Top_Mid_Label" value="est hï¿½bergï¿½ sur"/>
			<Column name="Btm_Start_Label" value="0..*"/>
			<Column name="Start_Edge" value="2"/>
			<Column name="End_Edge" value="4"/>
			<Column name="PtStartX" value="812"/>
			<Column name="PtStartY" value="-254"/>
			<Column name="PtEndX" value="986"/>
			<Column name="PtEndY" value="-254"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="PDATA5" value="SX=0;SY=0;EX=0;EY=0;EDGE=2;"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{2F6220FD-E102-4414-9535-53AF7426442C}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="1"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Unspecified;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Unspecified;"/>
			<Extension Start_Object_ID="{1C8F4B2F-BAB5-4328-9F44-F9CA3721015D}" End_Object_ID="{C2AC65EB-1D25-4d3e-859F-C48D308DB514}"/>
		</Row>
		<Row>
			<Column name="Connector_ID" value="8"/>
			<Column name="Name" value="mobilise"/>
			<Column name="Direction" value="Unspecified"/>
			<Column name="Connector_Type" value="Association"/>
			<Column name="SubType" value="Class"/>
			<Column name="SourceCard" value="0..*"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="0..*"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="0"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="6"/>
			<Column name="End_Object_ID" value="8"/>
			<Column name="Top_Mid_Label" value="mobilise"/>
			<Column name="Btm_Start_Label" value="0..*"/>
			<Column name="Start_Edge" value="3"/>
			<Column name="End_Edge" value="1"/>
			<Column name="PtStartX" value="424"/>
			<Column name="PtStartY" value="-312"/>
			<Column name="PtEndX" value="424"/>
			<Column name="PtEndY" value="-433"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="PDATA1" value="19"/>
			<Column name="PDATA5" value="EDGE=3;SX=0;SY=0;EX=0;EY=0;"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{34817746-24CF-4c95-93F0-693B3A27BB5A}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="1"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Unspecified;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Unspecified;"/>
			<Extension Start_Object_ID="{A02A9B57-1644-4ac6-9CF0-CA35B54DBA0E}" End_Object_ID="{9C36619A-26FA-49f9-8ECE-B23BEAB870CC}" PDATA1="{FC0FF3B3-0C69-4bdc-BF3E-16FC7F548FC6}"/>
		</Row>
		<Row>
			<Column name="Connector_ID" value="26"/>
			<Column name="Direction" value="Source -&gt; Destination"/>
			<Column name="Connector_Type" value="Association"/>
			<Column name="SourceCard" value="0..1"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="1"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceRole" value="FK_VersionTechno_Environnement"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestRole" value="PK_Environnement"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="0"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="40"/>
			<Column name="End_Object_ID" value="34"/>
			<Column name="Btm_Mid_Label" value="ï¿½FKï¿½"/>
			<Column name="Start_Edge" value="0"/>
			<Column name="End_Edge" value="0"/>
			<Column name="PtStartX" value="0"/>
			<Column name="PtStartY" value="0"/>
			<Column name="PtEndX" value="0"/>
			<Column name="PtEndY" value="0"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="VirtualInheritance" value="0"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{44ED1EA0-9981-4e46-8E37-60044CFBEB0A}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="StyleEx" value="Transformation=DDL;TransformedName=FK1;Source={AECC08A9-44FB-4abd-8BB3-81A0A6FF3637};FKINFO=SRC=FK_VersionTechno_Environnement:DST=PK_Environnement:;"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Non-Navigable;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Navigable;"/>
			<Extension Start_Object_ID="{A8A28228-C825-4449-B64D-6DB9125F97B5}" End_Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="Connector_ID" value="24"/>
			<Column name="Direction" value="Source -&gt; Destination"/>
			<Column name="Connector_Type" value="Association"/>
			<Column name="SourceCard" value="0..1"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="1"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceRole" value="FK_Affectation_Utilisateur"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestRole" value="PK_Utilisateur"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="0"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="32"/>
			<Column name="End_Object_ID" value="39"/>
			<Column name="Btm_Mid_Label" value="ï¿½FKï¿½"/>
			<Column name="Start_Edge" value="0"/>
			<Column name="End_Edge" value="0"/>
			<Column name="PtStartX" value="0"/>
			<Column name="PtStartY" value="0"/>
			<Column name="PtEndX" value="0"/>
			<Column name="PtEndY" value="0"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="VirtualInheritance" value="0"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{51F7D2C8-DF80-40a5-9F86-3CF2254041F1}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="StyleEx" value="Transformation=DDL;TransformedName=FK2;Source={34817746-24CF-4c95-93F0-693B3A27BB5A};FKINFO=SRC=FK_Affectation_Utilisateur:DST=PK_Utilisateur:;"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Non-Navigable;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Navigable;"/>
			<Extension Start_Object_ID="{DC020D7D-F87E-409d-AC5B-768E1178009A}" End_Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="Connector_ID" value="10"/>
			<Column name="Name" value="possï¿½de"/>
			<Column name="Direction" value="Unspecified"/>
			<Column name="Connector_Type" value="Association"/>
			<Column name="SourceCard" value="1"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="0..*"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="0"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="7"/>
			<Column name="End_Object_ID" value="6"/>
			<Column name="Top_Mid_Label" value="possï¿½de"/>
			<Column name="Btm_Start_Label" value="1"/>
			<Column name="Start_Edge" value="2"/>
			<Column name="End_Edge" value="4"/>
			<Column name="PtStartX" value="182"/>
			<Column name="PtStartY" value="-254"/>
			<Column name="PtEndX" value="356"/>
			<Column name="PtEndY" value="-254"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="PDATA5" value="SX=0;SY=0;EX=0;EY=0;"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{82025746-F470-4b70-954F-9E1C9F70BA29}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="1"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Unspecified;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Unspecified;"/>
			<Extension Start_Object_ID="{A7B42C3B-9BA7-444a-9164-53DF80D177BF}" End_Object_ID="{A02A9B57-1644-4ac6-9CF0-CA35B54DBA0E}"/>
		</Row>
		<Row>
			<Column name="Connector_ID" value="29"/>
			<Column name="Direction" value="Source -&gt; Destination"/>
			<Column name="Connector_Type" value="Association"/>
			<Column name="SourceCard" value="0..*"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="1"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceRole" value="FK_Environnement_contient"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestRole" value="PK_Projet"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="0"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="34"/>
			<Column name="End_Object_ID" value="36"/>
			<Column name="Btm_Mid_Label" value="ï¿½FKï¿½"/>
			<Column name="Start_Edge" value="0"/>
			<Column name="End_Edge" value="0"/>
			<Column name="PtStartX" value="0"/>
			<Column name="PtStartY" value="0"/>
			<Column name="PtEndX" value="0"/>
			<Column name="PtEndY" value="0"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="VirtualInheritance" value="0"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{90D69B8A-37B9-41ce-99F6-94CBDCDA49A2}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="StyleEx" value="Transformation=DDL;TransformedName=FK1;Source={25B5477C-1627-4934-8200-F208F1FB894B};FKINFO=SRC=FK_Environnement_contient:DST=PK_Projet:;"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Non-Navigable;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Navigable;"/>
			<Extension Start_Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}" End_Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="Connector_ID" value="28"/>
			<Column name="Direction" value="Source -&gt; Destination"/>
			<Column name="Connector_Type" value="Association"/>
			<Column name="SourceCard" value="0..*"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="1"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceRole" value="FK_Environnement_est hï¿½bergï¿½ sur"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestRole" value="PK_Serveur"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="0"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="34"/>
			<Column name="End_Object_ID" value="37"/>
			<Column name="Btm_Mid_Label" value="ï¿½FKï¿½"/>
			<Column name="Start_Edge" value="0"/>
			<Column name="End_Edge" value="0"/>
			<Column name="PtStartX" value="0"/>
			<Column name="PtStartY" value="0"/>
			<Column name="PtEndX" value="0"/>
			<Column name="PtEndY" value="0"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="VirtualInheritance" value="0"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{AA8257BE-07FF-4237-B06C-58315D867906}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="StyleEx" value="Transformation=DDL;TransformedName=FK1;Source={2F6220FD-E102-4414-9535-53AF7426442C};FKINFO=SRC=FK_Environnement_est hï¿½bergï¿½ sur:DST=PK_Serveur:;"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Non-Navigable;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Navigable;"/>
			<Extension Start_Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}" End_Object_ID="{2097F4D6-2054-4096-A530-4B473039D622}"/>
		</Row>
		<Row>
			<Column name="Connector_ID" value="25"/>
			<Column name="Direction" value="Source -&gt; Destination"/>
			<Column name="Connector_Type" value="Association"/>
			<Column name="SourceCard" value="0..*"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="1"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceRole" value="FK_Projet_possï¿½de"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestRole" value="PK_Client"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="0"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="36"/>
			<Column name="End_Object_ID" value="33"/>
			<Column name="Btm_Mid_Label" value="ï¿½FKï¿½"/>
			<Column name="Start_Edge" value="0"/>
			<Column name="End_Edge" value="0"/>
			<Column name="PtStartX" value="0"/>
			<Column name="PtStartY" value="0"/>
			<Column name="PtEndX" value="0"/>
			<Column name="PtEndY" value="0"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="VirtualInheritance" value="0"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{AB4F1E43-8AB4-4e43-B8F7-9EB9E75ED341}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="StyleEx" value="Transformation=DDL;TransformedName=FK1;Source={82025746-F470-4b70-954F-9E1C9F70BA29};FKINFO=SRC=FK_Projet_possï¿½de:DST=PK_Client:;"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Non-Navigable;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Navigable;"/>
			<Extension Start_Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}" End_Object_ID="{58A3CC04-A720-407d-81DC-DB30D3247A09}"/>
		</Row>
		<Row>
			<Column name="Connector_ID" value="9"/>
			<Column name="Name" value="utilise"/>
			<Column name="Direction" value="Unspecified"/>
			<Column name="Connector_Type" value="Association"/>
			<Column name="SubType" value="Class"/>
			<Column name="SourceCard" value="0..*"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="0..*"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="0"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="11"/>
			<Column name="End_Object_ID" value="12"/>
			<Column name="Top_Mid_Label" value="utilise"/>
			<Column name="Btm_End_Label" value="0..*"/>
			<Column name="Start_Edge" value="3"/>
			<Column name="End_Edge" value="1"/>
			<Column name="PtStartX" value="739"/>
			<Column name="PtStartY" value="-312"/>
			<Column name="PtEndX" value="739"/>
			<Column name="PtEndY" value="-433"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="PDATA1" value="20"/>
			<Column name="PDATA5" value="EDGE=3;SX=0;SY=0;EX=0;EY=0;"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{AECC08A9-44FB-4abd-8BB3-81A0A6FF3637}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="1"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Unspecified;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Unspecified;"/>
			<Extension Start_Object_ID="{1C8F4B2F-BAB5-4328-9F44-F9CA3721015D}" End_Object_ID="{74933CA6-06EB-4103-B908-1B97053678E9}" PDATA1="{9E44FF21-E97C-4393-B87A-660FBF7BFA60}"/>
		</Row>
		<Row>
			<Column name="Connector_ID" value="23"/>
			<Column name="Direction" value="Source -&gt; Destination"/>
			<Column name="Connector_Type" value="Association"/>
			<Column name="SourceCard" value="0..1"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="1"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceRole" value="FK_Affectation_Projet"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestRole" value="PK_Projet"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="0"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="32"/>
			<Column name="End_Object_ID" value="36"/>
			<Column name="Btm_Mid_Label" value="ï¿½FKï¿½"/>
			<Column name="Start_Edge" value="0"/>
			<Column name="End_Edge" value="0"/>
			<Column name="PtStartX" value="0"/>
			<Column name="PtStartY" value="0"/>
			<Column name="PtEndX" value="0"/>
			<Column name="PtEndY" value="0"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="VirtualInheritance" value="0"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{B2F83857-5BAD-4898-BBE4-23A263B07B86}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="StyleEx" value="Transformation=DDL;TransformedName=FK1;Source={34817746-24CF-4c95-93F0-693B3A27BB5A};FKINFO=SRC=FK_Affectation_Projet:DST=PK_Projet:;"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Non-Navigable;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Navigable;"/>
			<Extension Start_Object_ID="{DC020D7D-F87E-409d-AC5B-768E1178009A}" End_Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="Connector_ID" value="27"/>
			<Column name="Direction" value="Source -&gt; Destination"/>
			<Column name="Connector_Type" value="Association"/>
			<Column name="SourceCard" value="0..1"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="1"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceRole" value="FK_VersionTechno_Technologie"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestRole" value="PK_Technologie"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="0"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="40"/>
			<Column name="End_Object_ID" value="38"/>
			<Column name="Btm_Mid_Label" value="ï¿½FKï¿½"/>
			<Column name="Start_Edge" value="0"/>
			<Column name="End_Edge" value="0"/>
			<Column name="PtStartX" value="0"/>
			<Column name="PtStartY" value="0"/>
			<Column name="PtEndX" value="0"/>
			<Column name="PtEndY" value="0"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="VirtualInheritance" value="0"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{B3B57655-30CD-4450-A828-F48590ECD84B}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="StyleEx" value="Transformation=DDL;TransformedName=FK2;Source={AECC08A9-44FB-4abd-8BB3-81A0A6FF3637};FKINFO=SRC=FK_VersionTechno_Technologie:DST=PK_Technologie:;"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Non-Navigable;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Navigable;"/>
			<Extension Start_Object_ID="{A8A28228-C825-4449-B64D-6DB9125F97B5}" End_Object_ID="{930F4F1D-C6CA-4ee9-A1C3-F7A85CC03D63}"/>
		</Row>
		<Row>
			<Column name="Connector_ID" value="12"/>
			<Column name="Name" value="a pour"/>
			<Column name="Direction" value="Unspecified"/>
			<Column name="Connector_Type" value="Association"/>
			<Column name="SourceCard" value="0..*"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="1"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="0"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="8"/>
			<Column name="End_Object_ID" value="9"/>
			<Column name="Btm_Start_Label" value="0..*"/>
			<Column name="Start_Edge" value="3"/>
			<Column name="End_Edge" value="1"/>
			<Column name="PtStartX" value="424"/>
			<Column name="PtStartY" value="-548"/>
			<Column name="PtEndX" value="424"/>
			<Column name="PtEndY" value="-622"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="PDATA5" value="SX=0;SY=0;EX=0;EY=0;EDGE=3;"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{CFF64FBB-980E-4dc7-9959-09247DB9B23D}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="1"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Unspecified;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Unspecified;"/>
			<Extension Start_Object_ID="{9C36619A-26FA-49f9-8ECE-B23BEAB870CC}" End_Object_ID="{3DE948F4-C3A6-46d9-B8AD-C94607E24D09}"/>
		</Row>
		<Row>
			<Column name="Connector_ID" value="30"/>
			<Column name="Direction" value="Source -&gt; Destination"/>
			<Column name="Connector_Type" value="Association"/>
			<Column name="SourceCard" value="0..*"/>
			<Column name="SourceAccess" value="Public"/>
			<Column name="DestCard" value="1"/>
			<Column name="DestAccess" value="Public"/>
			<Column name="SourceRole" value="FK_Utilisateur_a pour"/>
			<Column name="SourceContainment" value="Unspecified"/>
			<Column name="SourceIsAggregate" value="0"/>
			<Column name="SourceIsOrdered" value="0"/>
			<Column name="DestRole" value="PK_Profil"/>
			<Column name="DestContainment" value="Unspecified"/>
			<Column name="DestIsAggregate" value="0"/>
			<Column name="DestIsOrdered" value="0"/>
			<Column name="Start_Object_ID" value="39"/>
			<Column name="End_Object_ID" value="35"/>
			<Column name="Btm_Mid_Label" value="ï¿½FKï¿½"/>
			<Column name="Start_Edge" value="0"/>
			<Column name="End_Edge" value="0"/>
			<Column name="PtStartX" value="0"/>
			<Column name="PtStartY" value="0"/>
			<Column name="PtEndX" value="0"/>
			<Column name="PtEndY" value="0"/>
			<Column name="SeqNo" value="0"/>
			<Column name="HeadStyle" value="0"/>
			<Column name="LineStyle" value="0"/>
			<Column name="RouteStyle" value="3"/>
			<Column name="IsBold" value="0"/>
			<Column name="LineColor" value="-1"/>
			<Column name="Stereotype" value="FK"/>
			<Column name="VirtualInheritance" value="0"/>
			<Column name="DiagramID" value="0"/>
			<Column name="ea_guid" value="{FC19C655-CB2E-44e6-97F9-460058CA7275}"/>
			<Column name="SourceIsNavigable" value="0"/>
			<Column name="DestIsNavigable" value="0"/>
			<Column name="IsRoot" value="0"/>
			<Column name="IsLeaf" value="0"/>
			<Column name="SourceChangeable" value="none"/>
			<Column name="DestChangeable" value="none"/>
			<Column name="SourceTS" value="instance"/>
			<Column name="DestTS" value="instance"/>
			<Column name="Target2" value="0"/>
			<Column name="StyleEx" value="Transformation=DDL;TransformedName=FK1;Source={CFF64FBB-980E-4dc7-9959-09247DB9B23D};FKINFO=SRC=FK_Utilisateur_a pour:DST=PK_Profil:;"/>
			<Column name="SourceStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Non-Navigable;"/>
			<Column name="DestStyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Navigable;"/>
			<Extension Start_Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}" End_Object_ID="{0253C706-2C51-42d9-A611-3F09FA19C5C0}"/>
		</Row>
	</Table>
	<Table name="t_diagram">
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Package_ID" value="2"/>
			<Column name="ParentID" value="0"/>
			<Column name="Diagram_Type" value="Logical"/>
			<Column name="Name" value="diag_classe"/>
			<Column name="Version" value="1.0"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="ShowDetails" value="0"/>
			<Column name="AttPub" value="1"/>
			<Column name="AttPri" value="1"/>
			<Column name="AttPro" value="1"/>
			<Column name="Orientation" value="P"/>
			<Column name="cx" value="826"/>
			<Column name="cy" value="1169"/>
			<Column name="Scale" value="100"/>
			<Column name="CreatedDate" value="2026-04-22 23:55:53"/>
			<Column name="ModifiedDate" value="2026-05-12 15:50:36"/>
			<Column name="ShowForeign" value="1"/>
			<Column name="ShowBorder" value="1"/>
			<Column name="ShowPackageContents" value="1"/>
			<Column name="PDATA" value="HideRel=0;ShowTags=0;ShowReqs=0;ShowCons=0;OpParams=1;ShowSN=0;ScalePI=0;PPgs.cx=0;PPgs.cy=0;PSize=9;ShowIcons=1;SuppCN=0;HideProps=0;HideParents=0;UseAlias=0;HideAtts=0;HideOps=0;HideStereo=0;HideEStereo=0;ShowRec=1;ShowRes=0;ShowShape=1;FormName=;"/>
			<Column name="Locked" value="0"/>
			<Column name="ea_guid" value="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}"/>
			<Column name="Swimlanes" value="locked=false;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;"/>
			<Column name="StyleEx" value="ExcludeRTF=0;DocAll=0;HideQuals=0;AttPkg=1;ShowTests=0;ShowMaint=0;SuppressFOC=1;MatrixActive=0;SwimlanesActive=1;KanbanActive=0;MatrixLineWidth=1;MatrixLineClr=0;MatrixLocked=0;TConnectorNotation=UML 2.1;TExplicitNavigability=0;AdvancedElementProps=1;AdvancedFeatureProps=1;AdvancedConnectorProps=1;m_bElementClassifier=1;SPT=1;MDGDgm=;STBLDgm=;ShowNotes=0;VisibleAttributeDetail=0;ShowOpRetType=1;SuppressBrackets=0;SuppConnectorLabels=0;PrintPageHeadFoot=0;ShowAsList=0;SuppressedCompartments=;Theme=:119;SaveTag=C3F19E30;"/>
			<Extension Package_ID="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="3"/>
			<Column name="Package_ID" value="4"/>
			<Column name="ParentID" value="0"/>
			<Column name="Diagram_Type" value="Logical"/>
			<Column name="Name" value="DDL"/>
			<Column name="Version" value="1.0"/>
			<Column name="Author" value="jub-ubuntu"/>
			<Column name="ShowDetails" value="0"/>
			<Column name="AttPub" value="1"/>
			<Column name="AttPri" value="1"/>
			<Column name="AttPro" value="1"/>
			<Column name="Orientation" value="P"/>
			<Column name="cx" value="826"/>
			<Column name="cy" value="1169"/>
			<Column name="Scale" value="100"/>
			<Column name="CreatedDate" value="2026-04-26 01:33:37"/>
			<Column name="ModifiedDate" value="2026-04-26 01:33:38"/>
			<Column name="ShowForeign" value="1"/>
			<Column name="ShowBorder" value="1"/>
			<Column name="ShowPackageContents" value="1"/>
			<Column name="PDATA" value="HideRel=0;ShowTags=0;ShowReqs=0;ShowCons=0;OpParams=1;ShowSN=0;ScalePI=0;PPgs.cx=0;PPgs.cy=0;PSize=9;ShowIcons=1;SuppCN=0;HideProps=0;HideParents=0;UseAlias=0;HideAtts=0;HideOps=0;HideStereo=0;HideEStereo=0;ShowRec=1;ShowRes=0;ShowShape=1;FormName=;"/>
			<Column name="Locked" value="0"/>
			<Column name="ea_guid" value="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}"/>
			<Column name="Swimlanes" value="locked=false;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;"/>
			<Column name="StyleEx" value="ExcludeRTF=0;DocAll=0;HideQuals=0;AttPkg=1;ShowTests=0;ShowMaint=0;SuppressFOC=1;MatrixActive=0;SwimlanesActive=1;KanbanActive=0;MatrixLineWidth=1;MatrixLineClr=0;MatrixLocked=0;TConnectorNotation=UML 2.1;TExplicitNavigability=0;AdvancedElementProps=1;AdvancedFeatureProps=1;AdvancedConnectorProps=1;m_bElementClassifier=1;SPT=1;MDGDgm=;STBLDgm=;ShowNotes=0;VisibleAttributeDetail=0;ShowOpRetType=1;SuppressBrackets=0;SuppConnectorLabels=0;PrintPageHeadFoot=0;ShowAsList=0;SuppressedCompartments=;Theme=:119;SaveTag=76D2D1D4;"/>
			<Extension Package_ID="{5B186279-D6A5-4612-A233-2C55FD32D359}"/>
		</Row>
	</Table>
	<Table name="t_diagramobjects">
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Object_ID" value="2"/>
			<Column name="RectTop" value="-21"/>
			<Column name="RectLeft" value="420"/>
			<Column name="RectRight" value="556"/>
			<Column name="RectBottom" value="-136"/>
			<Column name="Sequence" value="13"/>
			<Column name="ObjectStyle" value="DUID=702D227A;"/>
			<Column name="Instance_ID" value="1"/>
			<Extension Diagram_ID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" Object_ID="{666B04EE-1C5C-4438-B2AD-8DC7274ECADA}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Object_ID" value="4"/>
			<Column name="RectTop" value="-21"/>
			<Column name="RectLeft" value="234"/>
			<Column name="RectRight" value="370"/>
			<Column name="RectBottom" value="-136"/>
			<Column name="Sequence" value="12"/>
			<Column name="ObjectStyle" value="DUID=BD0ABD39;"/>
			<Column name="Instance_ID" value="3"/>
			<Extension Diagram_ID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" Object_ID="{27A8DAE9-616D-4564-AA2E-32FB0344CCB2}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Object_ID" value="5"/>
			<Column name="RectTop" value="-21"/>
			<Column name="RectLeft" value="616"/>
			<Column name="RectRight" value="752"/>
			<Column name="RectBottom" value="-136"/>
			<Column name="Sequence" value="11"/>
			<Column name="ObjectStyle" value="DUID=93996348;"/>
			<Column name="Instance_ID" value="4"/>
			<Extension Diagram_ID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" Object_ID="{8C149F02-5496-4a6d-8BD2-67DD97909651}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Object_ID" value="6"/>
			<Column name="RectTop" value="-166"/>
			<Column name="RectLeft" value="355"/>
			<Column name="RectRight" value="498"/>
			<Column name="RectBottom" value="-293"/>
			<Column name="Sequence" value="10"/>
			<Column name="ObjectStyle" value="DUID=E803EE28;"/>
			<Column name="Instance_ID" value="5"/>
			<Extension Diagram_ID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" Object_ID="{A02A9B57-1644-4ac6-9CF0-CA35B54DBA0E}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Object_ID" value="7"/>
			<Column name="RectTop" value="-172"/>
			<Column name="RectLeft" value="46"/>
			<Column name="RectRight" value="182"/>
			<Column name="RectBottom" value="-287"/>
			<Column name="Sequence" value="9"/>
			<Column name="ObjectStyle" value="DUID=34975EF1;"/>
			<Column name="Instance_ID" value="6"/>
			<Extension Diagram_ID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" Object_ID="{A7B42C3B-9BA7-444a-9164-53DF80D177BF}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Object_ID" value="8"/>
			<Column name="RectTop" value="-408"/>
			<Column name="RectLeft" value="356"/>
			<Column name="RectRight" value="492"/>
			<Column name="RectBottom" value="-523"/>
			<Column name="Sequence" value="8"/>
			<Column name="ObjectStyle" value="DUID=30513A4E;"/>
			<Column name="Instance_ID" value="7"/>
			<Extension Diagram_ID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" Object_ID="{9C36619A-26FA-49f9-8ECE-B23BEAB870CC}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Object_ID" value="9"/>
			<Column name="RectTop" value="-597"/>
			<Column name="RectLeft" value="356"/>
			<Column name="RectRight" value="492"/>
			<Column name="RectBottom" value="-712"/>
			<Column name="Sequence" value="7"/>
			<Column name="ObjectStyle" value="DUID=5D72A159;"/>
			<Column name="Instance_ID" value="8"/>
			<Extension Diagram_ID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" Object_ID="{3DE948F4-C3A6-46d9-B8AD-C94607E24D09}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Object_ID" value="11"/>
			<Column name="RectTop" value="-172"/>
			<Column name="RectLeft" value="666"/>
			<Column name="RectRight" value="812"/>
			<Column name="RectBottom" value="-287"/>
			<Column name="Sequence" value="6"/>
			<Column name="ObjectStyle" value="DUID=E329E3BE;"/>
			<Column name="Instance_ID" value="10"/>
			<Extension Diagram_ID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" Object_ID="{1C8F4B2F-BAB5-4328-9F44-F9CA3721015D}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Object_ID" value="12"/>
			<Column name="RectTop" value="-408"/>
			<Column name="RectLeft" value="671"/>
			<Column name="RectRight" value="807"/>
			<Column name="RectBottom" value="-523"/>
			<Column name="Sequence" value="5"/>
			<Column name="ObjectStyle" value="DUID=2CE48F84;"/>
			<Column name="Instance_ID" value="11"/>
			<Extension Diagram_ID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" Object_ID="{74933CA6-06EB-4103-B908-1B97053678E9}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Object_ID" value="14"/>
			<Column name="RectTop" value="-172"/>
			<Column name="RectLeft" value="986"/>
			<Column name="RectRight" value="1122"/>
			<Column name="RectBottom" value="-287"/>
			<Column name="Sequence" value="4"/>
			<Column name="ObjectStyle" value="DUID=A28E901F;"/>
			<Column name="Instance_ID" value="13"/>
			<Extension Diagram_ID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" Object_ID="{C2AC65EB-1D25-4d3e-859F-C48D308DB514}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Object_ID" value="19"/>
			<Column name="RectTop" value="-311"/>
			<Column name="RectLeft" value="492"/>
			<Column name="RectRight" value="602"/>
			<Column name="RectBottom" value="-381"/>
			<Column name="Sequence" value="3"/>
			<Column name="ObjectStyle" value="DUID=0B7BE0E3;"/>
			<Column name="Instance_ID" value="19"/>
			<Extension Diagram_ID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" Object_ID="{FC0FF3B3-0C69-4bdc-BF3E-16FC7F548FC6}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Object_ID" value="20"/>
			<Column name="RectTop" value="-311"/>
			<Column name="RectLeft" value="812"/>
			<Column name="RectRight" value="902"/>
			<Column name="RectBottom" value="-381"/>
			<Column name="Sequence" value="2"/>
			<Column name="ObjectStyle" value="DUID=CC59508B;"/>
			<Column name="Instance_ID" value="20"/>
			<Extension Diagram_ID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" Object_ID="{9E44FF21-E97C-4393-B87A-660FBF7BFA60}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="1"/>
			<Column name="Object_ID" value="44"/>
			<Column name="RectTop" value="-21"/>
			<Column name="RectLeft" value="812"/>
			<Column name="RectRight" value="948"/>
			<Column name="RectBottom" value="-136"/>
			<Column name="Sequence" value="1"/>
			<Column name="ObjectStyle" value="DUID=05D02FCF;"/>
			<Column name="Instance_ID" value="41"/>
			<Extension Diagram_ID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" Object_ID="{583F726F-3BD9-4c63-BE4D-8C75344A2D45}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="3"/>
			<Column name="Object_ID" value="32"/>
			<Column name="RectTop" value="-487"/>
			<Column name="RectLeft" value="334"/>
			<Column name="RectRight" value="507"/>
			<Column name="RectBottom" value="-673"/>
			<Column name="Sequence" value="9"/>
			<Column name="ObjectStyle" value="DUID=7A62C14A;"/>
			<Column name="Instance_ID" value="38"/>
			<Extension Diagram_ID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" Object_ID="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="3"/>
			<Column name="Object_ID" value="33"/>
			<Column name="RectTop" value="-249"/>
			<Column name="RectLeft" value="795"/>
			<Column name="RectRight" value="946"/>
			<Column name="RectBottom" value="-392"/>
			<Column name="Sequence" value="8"/>
			<Column name="ObjectStyle" value="DUID=5E81BB1B;"/>
			<Column name="Instance_ID" value="37"/>
			<Extension Diagram_ID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" Object_ID="{58A3CC04-A720-407d-81DC-DB30D3247A09}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="3"/>
			<Column name="Object_ID" value="34"/>
			<Column name="RectTop" value="-35"/>
			<Column name="RectLeft" value="315"/>
			<Column name="RectRight" value="526"/>
			<Column name="RectBottom" value="-286"/>
			<Column name="Sequence" value="7"/>
			<Column name="ObjectStyle" value="DUID=00FDBB82;"/>
			<Column name="Instance_ID" value="36"/>
			<Extension Diagram_ID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" Object_ID="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="3"/>
			<Column name="Object_ID" value="35"/>
			<Column name="RectTop" value="-615"/>
			<Column name="RectLeft" value="813"/>
			<Column name="RectRight" value="928"/>
			<Column name="RectBottom" value="-745"/>
			<Column name="Sequence" value="6"/>
			<Column name="ObjectStyle" value="DUID=DE1EA821;"/>
			<Column name="Instance_ID" value="35"/>
			<Extension Diagram_ID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" Object_ID="{0253C706-2C51-42d9-A611-3F09FA19C5C0}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="3"/>
			<Column name="Object_ID" value="36"/>
			<Column name="RectTop" value="-208"/>
			<Column name="RectLeft" value="585"/>
			<Column name="RectRight" value="736"/>
			<Column name="RectBottom" value="-433"/>
			<Column name="Sequence" value="5"/>
			<Column name="ObjectStyle" value="DUID=9C4B4160;"/>
			<Column name="Instance_ID" value="34"/>
			<Extension Diagram_ID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" Object_ID="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="3"/>
			<Column name="Object_ID" value="37"/>
			<Column name="RectTop" value="-69"/>
			<Column name="RectLeft" value="808"/>
			<Column name="RectRight" value="932"/>
			<Column name="RectBottom" value="-212"/>
			<Column name="Sequence" value="4"/>
			<Column name="ObjectStyle" value="DUID=664EE197;"/>
			<Column name="Instance_ID" value="33"/>
			<Extension Diagram_ID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" Object_ID="{2097F4D6-2054-4096-A530-4B473039D622}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="3"/>
			<Column name="Object_ID" value="38"/>
			<Column name="RectTop" value="-429"/>
			<Column name="RectLeft" value="802"/>
			<Column name="RectRight" value="938"/>
			<Column name="RectBottom" value="-572"/>
			<Column name="Sequence" value="3"/>
			<Column name="ObjectStyle" value="DUID=47E640B6;"/>
			<Column name="Instance_ID" value="32"/>
			<Extension Diagram_ID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" Object_ID="{930F4F1D-C6CA-4ee9-A1C3-F7A85CC03D63}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="3"/>
			<Column name="Object_ID" value="39"/>
			<Column name="RectTop" value="-594"/>
			<Column name="RectLeft" value="583"/>
			<Column name="RectRight" value="737"/>
			<Column name="RectBottom" value="-806"/>
			<Column name="Sequence" value="2"/>
			<Column name="ObjectStyle" value="DUID=C959763B;"/>
			<Column name="Instance_ID" value="31"/>
			<Extension Diagram_ID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" Object_ID="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
		</Row>
		<Row>
			<Column name="Diagram_ID" value="3"/>
			<Column name="Object_ID" value="40"/>
			<Column name="RectTop" value="-367"/>
			<Column name="RectLeft" value="46"/>
			<Column name="RectRight" value="255"/>
			<Column name="RectBottom" value="-553"/>
			<Column name="Sequence" value="1"/>
			<Column name="ObjectStyle" value="DUID=3C5907BA;"/>
			<Column name="Instance_ID" value="30"/>
			<Extension Diagram_ID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" Object_ID="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
		</Row>
	</Table>
	<Table name="t_diagramlinks">
		<Row>
			<Column name="DiagramID" value="1"/>
			<Column name="ConnectorID" value="8"/>
			<Column name="Geometry" value="EDGE=3;SX=0;SY=0;EX=0;EY=0;$LLB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=;LMT=CX=34:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=1:ROT=0;LMB=;LRT=;LRB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=30513A4E;SOID=E803EE28;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Instance_ID" value="7"/>
			<Extension DiagramID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" ConnectorID="{34817746-24CF-4c95-93F0-693B3A27BB5A}"/>
		</Row>
		<Row>
			<Column name="DiagramID" value="1"/>
			<Column name="ConnectorID" value="9"/>
			<Column name="Geometry" value="EDGE=3;SX=0;SY=0;EX=0;EY=0;$LLB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=;LMT=CX=24:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=1:ROT=0;LMB=;LRT=;LRB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=2CE48F84;SOID=E329E3BE;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Instance_ID" value="8"/>
			<Extension DiagramID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" ConnectorID="{AECC08A9-44FB-4abd-8BB3-81A0A6FF3637}"/>
		</Row>
		<Row>
			<Column name="DiagramID" value="1"/>
			<Column name="ConnectorID" value="10"/>
			<Column name="Geometry" value="SX=0;SY=0;EX=0;EY=0;EDGE=2;$LLB=CX=6:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=;LMT=CX=34:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=1:ROT=0;LMB=;LRT=;LRB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=E803EE28;SOID=34975EF1;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Instance_ID" value="9"/>
			<Extension DiagramID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" ConnectorID="{82025746-F470-4b70-954F-9E1C9F70BA29}"/>
		</Row>
		<Row>
			<Column name="DiagramID" value="1"/>
			<Column name="ConnectorID" value="11"/>
			<Column name="Geometry" value="SX=0;SY=0;EX=0;EY=0;EDGE=2;$LLB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=;LMT=CX=62:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=1:ROT=0;LMB=;LRT=;LRB=CX=6:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=A28E901F;SOID=E329E3BE;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Instance_ID" value="10"/>
			<Extension DiagramID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" ConnectorID="{2F6220FD-E102-4414-9535-53AF7426442C}"/>
		</Row>
		<Row>
			<Column name="DiagramID" value="1"/>
			<Column name="ConnectorID" value="12"/>
			<Column name="Geometry" value="SX=0;SY=0;EX=0;EY=0;EDGE=3;$LLB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=;LMT=CX=26:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=1:ROT=0;LMB=;LRT=;LRB=CX=6:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=5D72A159;SOID=30513A4E;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Instance_ID" value="11"/>
			<Extension DiagramID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" ConnectorID="{CFF64FBB-980E-4dc7-9959-09247DB9B23D}"/>
		</Row>
		<Row>
			<Column name="DiagramID" value="1"/>
			<Column name="ConnectorID" value="14"/>
			<Column name="Geometry" value="SX=0;SY=0;EX=0;EY=0;EDGE=4;$LLB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=;LMT=CX=33:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=-1:ROT=0;LMB=;LRT=;LRB=CX=6:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=E803EE28;SOID=E329E3BE;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Instance_ID" value="12"/>
			<Extension DiagramID="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}" ConnectorID="{25B5477C-1627-4934-8200-F208F1FB894B}"/>
		</Row>
		<Row>
			<Column name="DiagramID" value="3"/>
			<Column name="ConnectorID" value="23"/>
			<Column name="Geometry" value="SX=-86;SY=0;EX=-75;EY=-20;EDGE=4;$LLB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=CX=93:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMT=CX=80:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMB=CX=21:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRT=CX=44:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRB=CX=6:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=9C4B4160;SOID=7A62C14A;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Path" value="21:-580;21:-340;"/>
			<Column name="Instance_ID" value="27"/>
			<Extension DiagramID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" ConnectorID="{B2F83857-5BAD-4898-BBE4-23A263B07B86}"/>
		</Row>
		<Row>
			<Column name="DiagramID" value="3"/>
			<Column name="ConnectorID" value="24"/>
			<Column name="Geometry" value="SX=1;SY=-90;EX=-77;EY=0;EDGE=3;$LLB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=CX=110:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMT=CX=114:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMB=CX=21:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRT=CX=61:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRB=CX=6:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=C959763B;SOID=7A62C14A;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Path" value="421:-700;"/>
			<Column name="Instance_ID" value="28"/>
			<Extension DiagramID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" ConnectorID="{51F7D2C8-DF80-40a5-9F86-3CF2254041F1}"/>
		</Row>
		<Row>
			<Column name="DiagramID" value="3"/>
			<Column name="ConnectorID" value="25"/>
			<Column name="Geometry" value="SX=71;SY=0;EX=-75;EY=0;EDGE=2;$LLB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=CX=82:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMT=CX=78:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMB=CX=21:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRT=CX=43:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRB=CX=6:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=5E81BB1B;SOID=9C4B4160;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Instance_ID" value="24"/>
			<Extension DiagramID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" ConnectorID="{AB4F1E43-8AB4-4e43-B8F7-9EB9E75ED341}"/>
		</Row>
		<Row>
			<Column name="DiagramID" value="3"/>
			<Column name="ConnectorID" value="26"/>
			<Column name="Geometry" value="SX=1;SY=90;EX=-105;EY=0;EDGE=1;$LLB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=CX=146:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMT=CX=156:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMB=CX=21:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRT=CX=82:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRB=CX=6:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=00FDBB82;SOID=3C5907BA;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Path" value="151:-160;"/>
			<Column name="Instance_ID" value="21"/>
			<Extension DiagramID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" ConnectorID="{44ED1EA0-9981-4e46-8E37-60044CFBEB0A}"/>
		</Row>
		<Row>
			<Column name="DiagramID" value="3"/>
			<Column name="ConnectorID" value="27"/>
			<Column name="Geometry" value="SX=101;SY=0;EX=-68;EY=0;EDGE=2;$LLB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=CX=133:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMT=CX=130:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMB=CX=21:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRT=CX=69:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRB=CX=6:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=47E640B6;SOID=3C5907BA;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Path" value="531:-460;531:-500;"/>
			<Column name="Instance_ID" value="22"/>
			<Extension DiagramID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" ConnectorID="{B3B57655-30CD-4450-A828-F48590ECD84B}"/>
		</Row>
		<Row>
			<Column name="DiagramID" value="3"/>
			<Column name="ConnectorID" value="28"/>
			<Column name="Geometry" value="SX=101;SY=20;EX=-59;EY=0;EDGE=2;$LLB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=CX=148:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMT=CX=96:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMB=CX=21:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRT=CX=52:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRB=CX=6:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=664EE197;SOID=00FDBB82;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Instance_ID" value="25"/>
			<Extension DiagramID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" ConnectorID="{AA8257BE-07FF-4237-B06C-58315D867906}"/>
		</Row>
		<Row>
			<Column name="DiagramID" value="3"/>
			<Column name="ConnectorID" value="29"/>
			<Column name="Geometry" value="SX=1;SY=-126;EX=-75;EY=0;EDGE=3;$LLB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=CX=119:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMT=CX=80:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMB=CX=21:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRT=CX=44:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRB=CX=6:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=9C4B4160;SOID=00FDBB82;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Path" value="421:-320;"/>
			<Column name="Instance_ID" value="26"/>
			<Extension DiagramID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" ConnectorID="{90D69B8A-37B9-41ce-99F6-94CBDCDA49A2}"/>
		</Row>
		<Row>
			<Column name="DiagramID" value="3"/>
			<Column name="ConnectorID" value="30"/>
			<Column name="Geometry" value="SX=71;SY=20;EX=-57;EY=0;EDGE=2;$LLB=CX=17:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LLT=CX=91:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMT=CX=74:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LMB=CX=21:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRT=CX=41:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;LRB=CX=6:CY=14:OX=0:OY=0:HDN=0:BLD=0:ITA=0:UND=0:CLR=-1:ALN=1:DIR=0:ROT=0;IRHS=;ILHS=;"/>
			<Column name="Style" value="Mode=3;EOID=DE1EA821;SOID=C959763B;Color=-1;LWidth=0;"/>
			<Column name="Hidden" value="0"/>
			<Column name="Instance_ID" value="23"/>
			<Extension DiagramID="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}" ConnectorID="{FC19C655-CB2E-44e6-97F9-460058CA7275}"/>
		</Row>
	</Table>
	<Table name="t_xref">
		<Row>
			<Column name="XrefID" value="{BD69EC22-62CC-44e7-9E2C-397815EA87B8}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="element property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=table;FQName=EAUML::table;@ENDSTEREO;"/>
			<Column name="Client" value="{0253C706-2C51-42d9-A611-3F09FA19C5C0}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{254A2A5A-9189-4a63-8DAD-DECCB8A04157}"/>
			<Column name="Name" value="Table"/>
			<Column name="Type" value="Transformation"/>
			<Column name="Namespace" value="DDL"/>
			<Column name="Client" value="{0253C706-2C51-42d9-A611-3F09FA19C5C0}"/>
			<Column name="Supplier" value="{3DE948F4-C3A6-46d9-B8AD-C94607E24D09}"/>
			<Column name="Link" value="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{9E321DD6-20E5-4118-B47A-40DE84DF5E5B}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=PK;FQName=EAUML::PK;@ENDSTEREO;"/>
			<Column name="Client" value="{0413BA96-976C-47bc-9258-280D3EB4496C}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{2295D245-F51E-4e2e-A4AD-96584C614C26}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=enum;@ENDSTEREO;"/>
			<Column name="Client" value="{0D933147-4D08-4967-A5D5-431405D98BDF}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{0E6ECF1E-327B-4ef8-A433-CD316CB2E291}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{130A6636-3AA9-48fe-9666-347F8FC95770}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{32DC309B-DADA-486a-8E61-CFE2F0A15B86}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{150267EC-F434-47a6-8659-57B37E981EC0}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{1D63CF95-C911-4d86-8BD1-F0A8B92E1E33}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{153A0B4E-BD4F-441d-B6F1-6E57A87E4D9C}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{2B8A2871-D0AF-4ae7-BC7D-1E795F6E690F}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=PK;FQName=EAUML::PK;@ENDSTEREO;"/>
			<Column name="Client" value="{153D2402-5F31-4330-BB1B-9D64EAACD13A}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{E563796F-18CD-44d2-8FCF-FBF5216E6EAD}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{18170C85-8D87-4032-BA9C-61F353768AB4}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{99DD2380-0E7C-4bf0-B788-8B71E417BE5C}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=enum;@ENDSTEREO;"/>
			<Column name="Client" value="{1A627E84-5ABD-46e1-866A-4E2BC7407776}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{2FA678AA-785B-4b27-AE6C-559EBB92BF00}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="element property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=table;FQName=EAUML::table;@ENDSTEREO;"/>
			<Column name="Client" value="{2097F4D6-2054-4096-A530-4B473039D622}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{FCD928AC-A61C-4b65-8AC8-30EA47A6D79D}"/>
			<Column name="Name" value="Table"/>
			<Column name="Type" value="Transformation"/>
			<Column name="Namespace" value="DDL"/>
			<Column name="Client" value="{2097F4D6-2054-4096-A530-4B473039D622}"/>
			<Column name="Supplier" value="{C2AC65EB-1D25-4d3e-859F-C48D308DB514}"/>
			<Column name="Link" value="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{FDF2F4E4-071C-418a-ADBD-437B98869DC4}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{24216EE7-E9AA-4d93-B058-3C03CF2FCE9E}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{4C2B41E6-2789-4c50-8F24-686A7B67F456}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{25541B56-B77B-4bfe-8563-9761107F3D89}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{04F6CA46-A118-46ee-9130-CB77E0BAD809}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{28F28388-85DE-458f-83EE-3EBD59EB3754}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{1C4D2F18-264A-4f16-B99A-61B3F0864300}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=enum;@ENDSTEREO;"/>
			<Column name="Client" value="{33334975-F9F2-4e6c-946B-AD5EEBEC97D0}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{47069805-A4A9-4398-9471-5342791419AF}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{33C890B0-E904-4859-BE0C-62CD0402AA3C}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{0ABD4590-DB16-4731-AF6B-86943BBCAC43}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="element property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=table;FQName=EAUML::table;@ENDSTEREO;"/>
			<Column name="Client" value="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{7B164973-D54B-42a4-B2D8-4721BB8B9516}"/>
			<Column name="Name" value="Table"/>
			<Column name="Type" value="Transformation"/>
			<Column name="Namespace" value="DDL"/>
			<Column name="Client" value="{33EAA40B-395A-4c3a-BEFA-6B9E983F038B}"/>
			<Column name="Supplier" value="{1C8F4B2F-BAB5-4328-9F44-F9CA3721015D}"/>
			<Column name="Link" value="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{15F60772-E572-4a20-800A-982E377018BD}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{3607F91F-A939-4183-BBAB-42A059B88598}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{8D69ED3B-24CA-4e18-A546-08F4F53E08A5}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=enum;GUID={740E46B5-AA2D-4c98-A2D6-0613550DDF85};@ENDSTEREO;"/>
			<Column name="Client" value="{37DC2EC4-3287-418f-82AD-144FF82444C9}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{25335F40-9135-4e16-8042-2BDF3E47D908}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{381D7887-FAB3-423e-B265-E2646AA5FBA8}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{5258B30D-0232-424e-BD0F-1885DDA9B69D}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{3A934217-C198-41d1-BD53-C8276AAF329C}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{CD56C6E6-EFC5-4368-9190-E5F87A153097}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=PK;FQName=EAUML::PK;@ENDSTEREO;"/>
			<Column name="Client" value="{3C52AEB7-E947-47be-98D1-76D2F7C1CC09}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{3976DCA0-8AB1-43bd-99D1-90E5933C247E}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{3DFDA890-A62A-4fb6-82B5-183CBF2A60B9}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{F77C9E67-880E-4243-A38B-71E65B6B7816}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{3E6CC30C-B496-4ec0-BF28-34D48ED87444}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{01604491-95AA-44bd-A4ED-4112A683B288}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{411D75FD-B652-4d03-9E67-AD2270BB7FBF}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{7C01EB3C-90B2-4472-B80F-16B2E5085A33}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{41917495-D431-441c-AEBE-FD49A0112E70}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{E6AEF2C5-D89B-4d70-B58C-7B11A3F38797}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="element property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=table;FQName=EAUML::table;@ENDSTEREO;"/>
			<Column name="Client" value="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{73292D93-6C3D-4d07-AD10-AF71450C9DB3}"/>
			<Column name="Name" value="Table"/>
			<Column name="Type" value="Transformation"/>
			<Column name="Namespace" value="DDL"/>
			<Column name="Client" value="{429C06E3-FFF0-4ff6-860B-260E2DD91F5B}"/>
			<Column name="Supplier" value="{A02A9B57-1644-4ac6-9CF0-CA35B54DBA0E}"/>
			<Column name="Link" value="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{13F0BEA4-BDE5-433d-A4E6-88DF7FE8558F}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="connector property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{44ED1EA0-9981-4e46-8E37-60044CFBEB0A}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{47B9BD96-1042-4bf8-9965-3981FB411E37}"/>
			<Column name="Name" value="CustomProperties"/>
			<Column name="Type" value="diagram properties"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="DGS=On=0:CNT=8:W=120:H=40:SG=0:SGH=0:AEB=0:;AR=0;DCL=0;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;Swimlanes=locked=false;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;"/>
			<Column name="Client" value="{4C4AA1F3-A0D6-4262-8BA2-D4D891E0FF6E}"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{AD7309F7-18CC-4972-8526-F4E6EAC1952D}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=PK;FQName=EAUML::PK;@ENDSTEREO;"/>
			<Column name="Client" value="{4CE15537-DD6D-45c1-9239-938E771281E1}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{E83EE889-071F-43ca-9A08-B407C65ED3C7}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{4DFE76DC-D4F3-4faf-8E27-21B138E61403}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{D02D4D6B-E672-4aca-87D5-721D94836E54}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="connector property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{51F7D2C8-DF80-40a5-9F86-3CF2254041F1}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{54DF3FE8-144A-449e-867E-BEA410392464}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{541A65BA-67FD-4bf8-9F75-4A2F67565661}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{DE54BED1-B435-49c3-9ED7-F49EC320EBF9}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="element property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=table;FQName=EAUML::table;@ENDSTEREO;"/>
			<Column name="Client" value="{58A3CC04-A720-407d-81DC-DB30D3247A09}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{97DE1DBF-0290-4747-94E6-8382A77A9DCA}"/>
			<Column name="Name" value="Table"/>
			<Column name="Type" value="Transformation"/>
			<Column name="Namespace" value="DDL"/>
			<Column name="Client" value="{58A3CC04-A720-407d-81DC-DB30D3247A09}"/>
			<Column name="Supplier" value="{A7B42C3B-9BA7-444a-9164-53DF80D177BF}"/>
			<Column name="Link" value="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{C0C473CF-2C3E-4e56-A104-59C1BB9AAEDA}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="element property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=table;FQName=EAUML::table;@ENDSTEREO;"/>
			<Column name="Client" value="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{41C7D7DA-2DA9-4517-A06C-79E5A7AE1873}"/>
			<Column name="Name" value="Table"/>
			<Column name="Type" value="Transformation"/>
			<Column name="Namespace" value="DDL"/>
			<Column name="Client" value="{5B19746D-44D3-4312-80A2-6DA1CD252023}"/>
			<Column name="Supplier" value="{9C36619A-26FA-49f9-8ECE-B23BEAB870CC}"/>
			<Column name="Link" value="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{D2AEB1F8-B678-43bc-957A-A592529A34F3}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{5C435504-5D2F-4183-A36A-8A21711B2C1C}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{3A154315-F571-4cf8-819A-D84CC866744C}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{5E0E23D4-F1E9-4227-8B53-B74A87AEC92F}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{AB044D1C-BF77-43ed-8715-2A57BF72E3E0}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=enum;GUID={740E46B5-AA2D-4c98-A2D6-0613550DDF85};@ENDSTEREO;"/>
			<Column name="Client" value="{67D39D17-C903-4713-B5B4-A8939A92F8B4}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{5A2C042E-698B-4e26-B983-4042AF462319}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=PK;FQName=EAUML::PK;@ENDSTEREO;"/>
			<Column name="Client" value="{6FFF535A-076C-4014-AD7E-67E910E85515}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{316D6123-8B11-4da6-AB68-2D12C654C956}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{7074AA1D-8410-45d2-BC85-C7061BED2EAA}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{123C9370-5BE9-42ea-B3B4-6D19D8B8C9E6}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{7A20F9D7-C1F4-4db9-A57D-442E48E3FA35}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{27DAE7E8-8705-4e31-90C9-9FD88E8E441F}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{83918A54-7D16-441d-8AEA-A1CBEC93F2ED}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{CF9A11C2-851F-406b-938E-0E43475516A5}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{8456999B-3887-4c29-823F-F7A5755FAA3D}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{EBE543B7-7696-4c9a-A35B-0D3B00D677EC}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{8617DFA9-615B-4a90-AF0B-7F404DCE8559}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{12B48CCD-612E-493f-9231-7D10165C2289}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{86B96CDE-8198-4c0b-B345-FE2D9C1153D2}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{040F38B4-B17F-42d9-80A0-BAB213F6B712}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{894D61BA-BB6C-4738-955B-4B3B7FE0FB3F}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{DEBFC9A8-AC62-4efc-A6CF-EE4F2F5F85E2}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{8B75C004-9A7E-46ff-B40E-017347D1F34B}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{8505FA5A-F62D-454c-8E14-DB6C91E2FFB7}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{8EF3604A-C6E9-4ac0-A73E-EA5EE627F2C8}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{938EA5DA-677B-4172-8695-AD3D587AF846}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=enum;@ENDSTEREO;"/>
			<Column name="Client" value="{90BC064D-2422-4a1d-A161-A9D8210C2D6C}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{2171DDB1-A078-4d67-B2A8-F72907917378}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="connector property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{90D69B8A-37B9-41ce-99F6-94CBDCDA49A2}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{86C7D165-38EC-4f91-97C0-88EA9C41E261}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{91759616-6475-4837-A260-C674498940A5}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{16BA0754-B46A-4448-B8C9-D3C726D4C348}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="element property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=table;FQName=EAUML::table;@ENDSTEREO;"/>
			<Column name="Client" value="{930F4F1D-C6CA-4ee9-A1C3-F7A85CC03D63}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{1ECF48DA-9292-4d8f-8D33-845F24DE79F2}"/>
			<Column name="Name" value="Table"/>
			<Column name="Type" value="Transformation"/>
			<Column name="Namespace" value="DDL"/>
			<Column name="Client" value="{930F4F1D-C6CA-4ee9-A1C3-F7A85CC03D63}"/>
			<Column name="Supplier" value="{74933CA6-06EB-4103-B908-1B97053678E9}"/>
			<Column name="Link" value="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{18D27128-0D0E-4041-9825-91CD076DCB98}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{93439019-0116-4c75-BEEC-6249861BC9C5}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{5E52190F-78F5-4fcd-B743-AA0AACB4C0B5}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=enum;@ENDSTEREO;"/>
			<Column name="Client" value="{9B0ED433-B251-4c69-8E25-BD21C8D51755}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{CE4D0509-8D14-4abc-B7B8-D386031F2952}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{9C706C0F-AD0D-4034-B809-D6B6866795EC}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{8EEFE286-6FB9-4638-B2E0-E677621209D2}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{9E733395-E1F8-41f8-848E-EBF4F483E3B0}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{BCBE05FF-013F-479b-9E1E-9D55B96FC4BC}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{A6A3417B-0459-4526-B155-0788E27642FC}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{9917204E-3477-4146-824F-475E6ACD6FCC}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="element property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=table;FQName=EAUML::table;@ENDSTEREO;"/>
			<Column name="Client" value="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{F17756C1-D389-4afa-A9CF-DA929EAADC8D}"/>
			<Column name="Name" value="Table"/>
			<Column name="Type" value="Transformation"/>
			<Column name="Namespace" value="DDL"/>
			<Column name="Client" value="{A8A28228-C825-4449-B64D-6DB9125F97B5}"/>
			<Column name="Supplier" value="{9E44FF21-E97C-4393-B87A-660FBF7BFA60}"/>
			<Column name="Link" value="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{B7F06E3F-FDE0-4c0a-9BF9-7BB8E672D4A9}"/>
			<Column name="Name" value="CustomProperties"/>
			<Column name="Type" value="diagram properties"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="DGS=On=0:CNT=8:W=120:H=40:SG=0:SGH=0:AEB=0:;AR=0;DCL=0;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;Swimlanes=locked=false;orientation=0;width=0;inbar=false;names=false;color=-1;bold=false;fcol=0;tcol=-1;ofCol=-1;ufCol=-1;hl=1;ufh=0;hh=0;cls=0;bw=0;hli=0;bro=0;SwimlaneFont=lfh:-10,lfw:0,lfi:0,lfu:0,lfs:0,lfface:Carlito,lfe:0,lfo:0,lfchar:1,lfop:0,lfcp:0,lfq:0,lfpf=0,lfWidth=0;;"/>
			<Column name="Client" value="{A9F23440-D8FF-4adf-87C5-EB0F7D4006BA}"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{74928FB6-797B-421b-B359-0EDFD94AE939}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{AA2B2BF9-092B-465d-B968-852B79E017E3}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{5F7713B5-4AA0-4252-94D5-7987BC9D8345}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="connector property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{AA8257BE-07FF-4237-B06C-58315D867906}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{E784E554-4E4A-4b1e-BC88-B9E18E5A2751}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="connector property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{AB4F1E43-8AB4-4e43-B8F7-9EB9E75ED341}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{75A83525-C301-4b76-9100-A81662690BB5}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{AC957583-A735-40fb-B2E7-AC474075A35F}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{3AC5F592-7B1D-47ba-B87D-08F8559426BC}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=enum;@ENDSTEREO;"/>
			<Column name="Client" value="{AE7B746D-996F-4d05-A642-4935D8C0CC5C}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{43036F50-333A-455c-BBFC-A382EB3DB07F}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{AEBD4F8F-7BF5-420d-9420-93179C199C9D}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{CC925C47-FBFE-4f01-BD05-42C5A8208D18}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="connector property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{B2F83857-5BAD-4898-BBE4-23A263B07B86}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{E94E0DF2-F627-40e9-940C-9AB862F5C8A0}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="connector property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{B3B57655-30CD-4450-A828-F48590ECD84B}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{B0FD75F1-B686-4275-A269-709040F46681}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{B910DA63-7BAB-4d7a-A1FE-4EDFFF2258CE}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{F87E6CE2-A777-4db3-A253-C06CD7BA9716}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{BFDF1B30-DC55-4f37-935B-491A4C281955}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{C6168000-2B41-4c6c-866C-9F4FD141F39F}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{BFFAB5BF-3164-4b21-B7EF-E01393054569}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{FB2B8566-9750-422c-A348-3C21EFD43F34}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=enum;@ENDSTEREO;"/>
			<Column name="Client" value="{C52A4F56-E701-4492-B6C8-5F0A4E590871}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{CF3CA4D0-BDCB-48db-BE04-930E74765685}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=enum;GUID={740E46B5-AA2D-4c98-A2D6-0613550DDF85};@ENDSTEREO;"/>
			<Column name="Client" value="{C6685B47-557F-40d8-8324-83F4A0D37313}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{79A7E020-7164-47ea-BC28-C21BFF2CA87A}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=PK;FQName=EAUML::PK;@ENDSTEREO;"/>
			<Column name="Client" value="{C6A8666F-0638-4cbb-9827-83B9E7CA9250}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{334DED93-5EA6-4749-A17F-90BA3EB5DB4C}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{C6BF386A-3091-4c7f-B181-7AD9A147E53E}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{7C85153E-B619-45b7-984B-6BE4533090D3}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=enum;@ENDSTEREO;"/>
			<Column name="Client" value="{C7C70D81-770A-4f22-BEF7-9501532B616E}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{A71C7CCA-A6BF-4427-8570-10BF28239445}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=enum;@ENDSTEREO;"/>
			<Column name="Client" value="{D648AB0F-8AC2-4767-A71C-8DC9763C5CDB}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{2F44CC45-BBFB-43e5-B467-6BC9B80ABE73}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{D64A5E2A-9BFB-4a6c-BB03-7B67C8E1C2DD}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{9623740E-BC38-4e6e-A266-0F1A33B5818C}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="element property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=table;FQName=EAUML::table;@ENDSTEREO;"/>
			<Column name="Client" value="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{FD0111FD-C573-409e-B1CD-88C29B7772FC}"/>
			<Column name="Name" value="Table"/>
			<Column name="Type" value="Transformation"/>
			<Column name="Namespace" value="DDL"/>
			<Column name="Client" value="{DC020D7D-F87E-409d-AC5B-768E1178009A}"/>
			<Column name="Supplier" value="{FC0FF3B3-0C69-4bdc-BF3E-16FC7F548FC6}"/>
			<Column name="Link" value="{3ED13B6A-45CF-45e5-9FEB-ABA6E70CF269}"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{0C5E7EB5-2A91-4eb9-8DF7-CD7BFD9CC9DC}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=PK;FQName=EAUML::PK;@ENDSTEREO;"/>
			<Column name="Client" value="{DF7584A8-161C-41bb-B676-BF8ACA05CE12}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{1F31D231-5677-40b7-ADFB-1DEF7B963617}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=enum;@ENDSTEREO;"/>
			<Column name="Client" value="{E167433D-AB81-4968-8EF0-617635190618}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{4FC8A4EE-3BE8-462b-B68A-3C28BDEE4203}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{E2967D20-1CF2-4889-8625-93009DF57635}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{3C6DEED4-4EFA-4fa6-B81D-835C6D4EFE4C}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{E54EF0A2-73EE-494a-AD1D-7CAD70D08599}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{E7471813-7655-47f5-A834-9A1EDF2A983D}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=PK;FQName=EAUML::PK;@ENDSTEREO;"/>
			<Column name="Client" value="{E6D6708D-CDC8-4e5d-895A-37D5755E4F07}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{405AEA6B-EA87-43c6-8C2C-F088BD740B65}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{E78FF488-74B2-4d88-9033-D2E49CE95C53}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{786B5652-7BE0-420c-AE3F-A12AF1DD9218}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{E87D5A1D-A2A3-4503-B255-8356434811AA}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{C793D63F-5B1C-47a6-8D41-4CDACD95079D}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{EADD6899-84B5-4fe1-A862-4BBD05CC2982}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{72E0B437-39D1-41c0-AB91-920663F7B17B}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{EAE6C3B9-4ACB-4c7d-B917-1D5392BF19B9}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{6C4E6727-C7FB-4ede-A050-3702A6F5223B}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{EDFB6ED0-F7F4-474c-8E70-31F61125646C}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{CFCBB914-C22E-4ad5-B9CA-4D233151B55E}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{EE300622-5C3F-42e2-853A-685BCA6C377F}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{40465C8C-188F-4cad-954A-BFE5FE25AD2E}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=PK;FQName=EAUML::PK;@ENDSTEREO;"/>
			<Column name="Client" value="{F245FBF7-78A0-4b7b-B6FB-EE4C7E360205}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{CC5E3EB7-5EA2-4787-8B34-C02CABF86505}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{F6029C55-3C00-4e0c-97BD-F0A6EF0006D2}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{5C5B6929-84A8-4e50-BB00-B3CCF5DA6E3E}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{F6908F11-566E-4ca7-AA8B-45AD2C35C6A1}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{F18227CE-A1C6-4f7a-AE50-50552C548645}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{F6ED4473-570D-4804-93BF-5EFC4FD61383}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{ADBCA12A-7CF2-4bca-A7E9-64E3E97284EA}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="operation property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{FBEF830F-7D3B-4dd5-A825-53AACEC91E3C}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{7B054C87-B0D9-40b1-B48C-2078D5738E1A}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="connector property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=FK;FQName=EAUML::FK;@ENDSTEREO;"/>
			<Column name="Client" value="{FC19C655-CB2E-44e6-97F9-460058CA7275}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{00FF99D2-CF1D-4bae-A4E0-4B13D3B4CED1}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{FCF2BC47-F223-4282-8378-965FF11F235F}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
		<Row>
			<Column name="XrefID" value="{948D4409-1C4C-4572-8123-0BAE8AE4CD7E}"/>
			<Column name="Name" value="Stereotypes"/>
			<Column name="Type" value="attribute property"/>
			<Column name="Visibility" value="Public"/>
			<Column name="Partition" value="0"/>
			<Column name="Description" value="@STEREO;Name=column;FQName=EAUML::column;@ENDSTEREO;"/>
			<Column name="Client" value="{FF0A5386-FB77-4ce2-9E21-95F46BEF641B}"/>
			<Column name="Supplier" value="&lt;none&gt;"/>
		</Row>
	</Table>
</Package>